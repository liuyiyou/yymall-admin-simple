/**
 * 
 * 惠购 - 惠购网 - www.huiget.com - 特别会购！
 * Copyright © 2014 惠购 www.huiget.com 版权所有
 */
package cn.liuyiyou.yishop.web.controller.member;

import cn.liuyiyou.yishop.biz.register.RegisterManager;
import cn.liuyiyou.yishop.common.util.CookieUtil;
import cn.liuyiyou.yishop.common.util.constansts.Constants;
import cn.liuyiyou.yishop.entity.LoginInfo;
import cn.liuyiyou.yishop.entity.User;
import cn.liuyiyou.yishop.service.LoginService;
import cn.liuyiyou.yishop.service.UserService;
import cn.liuyiyou.yishop.web.form.member.RegisterForm;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author yaofang
 * @version $Id: RegisterController.java, v 0.1 2014年10月3日 上午10:01:59 yaofang Exp $
 */
@Controller
@RequestMapping(value = "/member/")
public class RegisterController2 {

    @Autowired
    private RegisterManager registerManager;

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(@ModelAttribute("form") RegisterForm form) {

        return "member/register";

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(@ModelAttribute("form") RegisterForm form, HttpServletRequest request, HttpServletResponse response) {
        if (form.hasError()) {
            return "member/register";
        }

        registerManager.txRegister(StringUtils.lowerCase(form.getUserName()), DigestUtils.md5Hex(form.getPassword()), form.getWebContext().getIp());

        // 注册后自动登录
        LoginInfo loginInfo = loginService.findLoginInfoByUserName(form.getUserName());
        User user = null;
        if (loginInfo != null && (user = userService.findById(loginInfo.getUserId())) != null) {
            CookieUtil cookieUtil = new CookieUtil(request, response);
            cookieUtil.setCookie(Constants.COOKIE_CONTEXT_ID, user.getId() + ":" + loginInfo.getId());

            cookieUtil.setCookie(Constants.COOKIE_USER_NAME, form.getUserName(), 7 * 24 * 3600);
        }

        return "redirect:/";
    }

}
