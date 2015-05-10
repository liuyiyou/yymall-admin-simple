/**
 * 
 * 惠购 - 惠购网 - www.huiget.com - 特别会购！
 * Copyright © 2014 惠购 www.huiget.com 版权所有
 */
package cn.liuyiyou.yishop.biz.validate;

import cn.liuyiyou.yishop.common.util.constansts.Constants;
import cn.liuyiyou.yishop.entity.LoginInfo;
import cn.liuyiyou.yishop.entity.User;
import cn.liuyiyou.yishop.entity.ValidateInfo;
import cn.liuyiyou.yishop.service.LoginService;
import cn.liuyiyou.yishop.service.UserService;
import cn.liuyiyou.yishop.service.ValidateInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 
 * @author yaofang
 * @version $Id: ValidateManager.java, v 0.1 2014年10月6日 下午4:56:58 yaofang Exp $
 */
@Component
public class ValidateManager {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private ValidateInfoService validateInfoService;

    public void txActiveEmail(User user, ValidateInfo validateInfo) {
        String email = validateInfo.getTarget();
        int userId = user.getId();
        if (!StringUtils.equals(user.getEmail(), email)) {
            userService.modifyEmail(userId, email);
        }
        userService.modifyEmailValidated(userId, Constants.STATUS_VALID);

        LoginInfo loginInfo = loginService.findLoginInfoByUserIdAndLoginType(userId, Constants.LOGIN_TYPE_EMAIL);
        if (loginInfo == null) {
            loginInfo = loginService.findLoginInfoByUserId(userId).get(0);

            LoginInfo anotherLoginInfo = new LoginInfo();
            anotherLoginInfo.setUserName(email);
            anotherLoginInfo.setLoginType(Constants.LOGIN_TYPE_EMAIL);
            anotherLoginInfo.setPassword(loginInfo.getPassword());
            anotherLoginInfo.setUserId(loginInfo.getUserId());
            anotherLoginInfo.setCreator(email);

            loginService.add(anotherLoginInfo);
        } else {
            loginService.modifyUserName(userId, email, Constants.LOGIN_TYPE_EMAIL);
        }

        validateInfo.setStatus(Constants.STATUS_INVALID);
        validateInfoService.updateStatus(validateInfo);
    }

    public void txActiveMobilePhone(User user, ValidateInfo validateInfo) {
        String mobilePhone = validateInfo.getTarget();
        int userId = user.getId();
        if (!StringUtils.equals(user.getMobilePhone(), mobilePhone)) {
            userService.modifyMobilePhone(userId, mobilePhone);
        }
        userService.modifyMobilePhoneValidated(userId, Constants.STATUS_VALID);

        LoginInfo loginInfo = loginService.findLoginInfoByUserIdAndLoginType(userId, Constants.LOGIN_TYPE_MOBILE_PHONE);
        if (loginInfo == null) {
            loginInfo = loginService.findLoginInfoByUserId(userId).get(0);

            LoginInfo anotherLoginInfo = new LoginInfo();
            anotherLoginInfo.setUserName(mobilePhone);
            anotherLoginInfo.setLoginType(Constants.LOGIN_TYPE_MOBILE_PHONE);
            anotherLoginInfo.setPassword(loginInfo.getPassword());
            anotherLoginInfo.setUserId(loginInfo.getUserId());
            anotherLoginInfo.setCreator(mobilePhone);

            loginService.add(anotherLoginInfo);
        } else {
            loginService.modifyUserName(userId, mobilePhone, Constants.LOGIN_TYPE_MOBILE_PHONE);
        }

        validateInfo.setStatus(Constants.STATUS_INVALID);
        validateInfoService.updateStatus(validateInfo);
    }
}
