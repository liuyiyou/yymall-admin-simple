/**
 * 
 * 惠购 - 惠购网 - www.huiget.com - 特别会购！
 * Copyright © 2014 惠购 www.huiget.com 版权所有
 */
package cn.liuyiyou.yishop.web.controller.member.account;

import cn.liuyiyou.yishop.biz.validate.ValidateManager;
import cn.liuyiyou.yishop.common.util.URLUtil;
import cn.liuyiyou.yishop.common.util.ValidateCodeGenerater;
import cn.liuyiyou.yishop.common.util.constansts.ValidateInfoConstants;
import cn.liuyiyou.yishop.entity.User;
import cn.liuyiyou.yishop.entity.ValidateInfo;
import cn.liuyiyou.yishop.service.UserService;
import cn.liuyiyou.yishop.service.ValidateInfoService;
import cn.liuyiyou.yishop.web.form.member.account.ValidateEmailForm;
import cn.liuyiyou.yishop.web.form.member.account.validator.ValidateEmailFormValidator;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author yaofang
 * @version $Id: EmailValidateController.java, v 0.1 2014年10月6日 下午3:08:09 yaofang Exp $
 */
@Controller
@RequestMapping(value = "/member/account/")
public class ValidateEmailController {

    @Autowired
    private UserService userService;

    @Autowired
    private ValidateInfoService validateInfoService;

    @Autowired
    private ValidateManager validateManager;

    @Autowired
    private ValidateEmailFormValidator validator;

    @RequestMapping(value = "/validate-email", method = RequestMethod.GET)
    public String validateEmail(@ModelAttribute("form") ValidateEmailForm form) {
        User user = userService.findById(form.getWebContext().getUserId());
        form.setUser(user);
        form.setEmail(user.getEmail());

        return "member/account/validate-email";

    }

    @RequestMapping(value = "/validate-email", method = RequestMethod.POST)
    public String doValidateEmail(@ModelAttribute("form") ValidateEmailForm form,
                                  HttpServletRequest request) {
        int userId = form.getWebContext().getUserId();
        User user = userService.findById(form.getWebContext().getUserId());

        validator.validate(form, user.getEmail(), user.getEmailValidated(), request);

        if (form.hasError()) {
            return "member/account/validate-email";
        }

        // TODO 发送email

        String email = StringUtils.lowerCase(form.getEmail());
        ValidateInfo validateInfo = new ValidateInfo();
        validateInfo.setCode(ValidateCodeGenerater.generate(userId, email,
                ValidateInfoConstants.VALIDATE_TYPE_VALIDATE_EMAIL));
        validateInfo.setExpireTime(ValidateInfoConstants.VALIDATE_EXPIRE_TIME_VALIDATE_EMAIL);
        validateInfo.setTarget(email);
        validateInfo.setType(ValidateInfoConstants.VALIDATE_TYPE_VALIDATE_EMAIL);
        validateInfo.setUserId(userId);

        validateInfoService.add(validateInfo);

        return "redirect:/member/account/validate-email-notice?email=" + email + "&checkcode="
               + validateInfo.getCode();

    }

    @RequestMapping(value = "/validate-email-notice", method = RequestMethod.GET)
    public String validateEmailNotice(@ModelAttribute("form") ValidateEmailForm form) {

        return "member/account/validate-email-notice";

    }

    @RequestMapping(value = "/active-email")
    public String activeEmail(@ModelAttribute("form") ValidateEmailForm form) {
        ValidateInfo validateInfo = validateInfoService.findValidateInfoByCode(form.getCheckcode());
        User user = null;
        if (validateInfo == null
            || !validateInfo.valid(ValidateInfoConstants.VALIDATE_TYPE_VALIDATE_EMAIL)
            || (user = userService.findById(validateInfo.getUserId())) == null) {

            return "redirect:/member/notice?status=0&title=" + URLUtil.encode("验证邮箱") + "&reason="
                   + URLUtil.encode("链接失效");
        }

        validateManager.txActiveEmail(user, validateInfo);

        return "redirect:/member/notice?title=" + URLUtil.encode("验证邮箱");
    }

}
