package cn.liuyiyou.yishop.biz.register;

import java.util.Date;

import cn.liuyiyou.yishop.common.util.RegexUtil;
import cn.liuyiyou.yishop.common.util.constansts.Constants;
import cn.liuyiyou.yishop.entity.Account;
import cn.liuyiyou.yishop.entity.LoginInfo;
import cn.liuyiyou.yishop.entity.LoginLog;
import cn.liuyiyou.yishop.service.AccountService;
import cn.liuyiyou.yishop.service.LoginLogService;
import cn.liuyiyou.yishop.service.LoginService;
import cn.liuyiyou.yishop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 */
@Component
public class RegisterManager {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private LoginLogService loginLogService;

    public void txRegister(String userName, String password, String loginIp) {
        Date date = new Date();
        // 插用户表
        int userId = userService.addUser(userName);

        // 创建账户
        Account account = new Account();
        account.setUserId(userId);
        accountService.add(account);

        // 插登录信息表
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setCreator(userName);
        loginInfo.setLastLoginTime(date);
        String loginType = RegexUtil.isEmail(userName) ? Constants.LOGIN_TYPE_EMAIL : Constants.LOGIN_TYPE_MOBILE_PHONE;
        loginInfo.setLoginType(loginType);
        loginInfo.setPassword(password);
        loginInfo.setUserId(userId);
        loginInfo.setUserName(userName);

        int loginId = loginService.add(loginInfo);

        // 登记登录日志
        LoginLog loginLog = new LoginLog();
        loginLog.setLoginId(loginId);
        loginLog.setLoginIp(loginIp);
        loginLog.setLoginTime(date);
        loginLog.setLoginType(loginType);
        loginLog.setUserId(userId);

        loginLogService.add(loginLog);
    }

}
