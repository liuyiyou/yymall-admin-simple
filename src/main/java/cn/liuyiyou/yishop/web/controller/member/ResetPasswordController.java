/**
 * 
 * 惠购 - 惠购网 - www.huiget.com - 特别会购！
 * Copyright © 2014 惠购 www.huiget.com 版权所有
 */
package cn.liuyiyou.yishop.web.controller.member;

import cn.liuyiyou.yishop.web.form.BaseForm;
import cn.liuyiyou.yishop.web.form.member.ResetPasswordForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author yaofang
 * @version $Id: ResetPasswordController.java, v 0.1 2014年10月3日 上午10:24:26 yaofang Exp $
 */
@Controller
@RequestMapping(value = "/member/")
public class ResetPasswordController extends BaseForm {

    @RequestMapping(value = "/reset-password", method = RequestMethod.GET)
    public String resetPassword(@ModelAttribute("form") ResetPasswordForm form) {

        return "member/reset-password";

    }

    @RequestMapping(value = "/reset-password", method = RequestMethod.POST)
    public String doResetPassword(@ModelAttribute("form") ResetPasswordForm form) {

        return "login";

    }

    @RequestMapping(value = "/reset-password-mail", method = RequestMethod.GET)
    public String resetPasswordMail(@ModelAttribute("form") ResetPasswordForm form) {

        return "member/reset-password-mail";

    }

    @RequestMapping(value = "/reset-password-mail", method = RequestMethod.POST)
    public String doResetPasswordMail(@ModelAttribute("form") ResetPasswordForm form) {

        return "login";

    }

}
