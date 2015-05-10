/**
 * 
 * 惠购 - 惠购网 - www.huiget.com - 特别会购！
 * Copyright © 2014 惠购 www.huiget.com 版权所有
 */
package cn.liuyiyou.yishop.web.controller.member.account;

import cn.liuyiyou.yishop.common.util.URLUtil;
import cn.liuyiyou.yishop.entity.User;
import cn.liuyiyou.yishop.service.UserService;
import cn.liuyiyou.yishop.web.form.member.account.SetTransPasswordForm;
import cn.liuyiyou.yishop.web.form.member.account.validator.SetTransPasswordFormValidator;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author yaofang
 * @version $Id: SetTransPasswordController.java, v 0.1 2014年10月6日 下午12:15:22 yaofang Exp $
 */
@Controller
@RequestMapping(value = "/member/account/")
public class SetTransPasswordController {

    @Autowired
    private UserService userService;

    @Autowired
    private SetTransPasswordFormValidator validator;

    @RequestMapping(value = "/set-trans-password", method = RequestMethod.GET)
    public String setTransPassword(@ModelAttribute("form") SetTransPasswordForm form) {
        User user = userService.findById(form.getWebContext().getUserId());
        form.setUser(user);
        if (StringUtils.isNotBlank(user.getTransPassword())) {
            return "redirect:/member/account/modify-trans-password";
        }

        return "member/account/set-trans-password";

    }

    @RequestMapping(value = "/set-trans-password", method = RequestMethod.POST)
    public String doSetTransPassword(@ModelAttribute("form") SetTransPasswordForm form) {
        User user = userService.findById(form.getWebContext().getUserId());
        form.setUser(user);
        if (StringUtils.isNotBlank(user.getTransPassword())) {
            return "redirect:/member/account/modify-trans-password";
        }

        validator.validate(form);

        if (form.hasError()) {
            return "member/account/set-trans-password";
        }

        userService.modifyTransPassword(user.getId(), DigestUtils.md5Hex(form.getPassword()));

        return "redirect:/member/notice?title=" + URLUtil.encode("设置支付密码") + "&returnURI=/member/account/account-safe";

    }

}
