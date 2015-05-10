package cn.liuyiyou.yishop.web.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.liuyiyou.yishop.biz.login.LoginManager;
import cn.liuyiyou.yishop.common.util.CookieUtil;
import cn.liuyiyou.yishop.common.util.constansts.Constants;
import cn.liuyiyou.yishop.entity.LoginInfo;
import cn.liuyiyou.yishop.entity.User;
import cn.liuyiyou.yishop.service.LoginService;
import cn.liuyiyou.yishop.service.UserService;
import cn.liuyiyou.yishop.web.form.member.LoginForm;

/**
 * 登陆，这个和Admin不一样，只有在特定的url才需要进行登陆
 * @author liuyiyou
 *
 */
@Controller
@RequestMapping(value = "/user/")
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private LoginService loginService;

	@Autowired
	private LoginManager loginManager;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@ModelAttribute("form") LoginForm form,
			HttpServletRequest request, HttpServletResponse response) {

		CookieUtil cookieUtil = new CookieUtil(request, response);
		String cookieUserName = cookieUtil
				.getCookie(Constants.COOKIE_USER_NAME);
		form.setUserName(cookieUserName);

		return "user/login";

	}

	//集成Shiro
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute("form") LoginForm form,
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("进入登陆。。。。。。。");
		
		if (form.hasError()) {
			return "user/login";
		}

		LoginInfo loginInfo = loginService.findLoginInfoByUserNameAndPassword(
				form.getUserName(), DigestUtils.md5Hex(form.getPassword()));
		User user = null;
		if (loginInfo == null
				|| (user = userService.findById(loginInfo.getUserId())) == null) {
			form.putError("userName", "用户名或密码不正确");

			return "user/login";
		}

		loginManager.txLogin(loginInfo, form.getWebContext().getIp(), null);

		CookieUtil cookieUtil = new CookieUtil(request, response);
		if (form.getRemember() == 1) {
			cookieUtil.setCookie(Constants.COOKIE_CONTEXT_ID, user.getId()
					+ ":" + loginInfo.getId(), 7 * 24 * 3600);
		} else {
			cookieUtil.setCookie(Constants.COOKIE_CONTEXT_ID, user.getId()
					+ ":" + loginInfo.getId());
		}

		cookieUtil.setCookie(Constants.COOKIE_USER_NAME, form.getUserName(),
				7 * 24 * 3600);

		return getRedirectURL(form.getRedirectURL());

	}

	private String getRedirectURL(String redirectURL) {
		return "redirect:"
				+ (StringUtils.isBlank(redirectURL) ? "/" : redirectURL);
	}
}
