package cn.liuyiyou.yishop.biz.login;

import cn.liuyiyou.yishop.entity.LoginInfo;
import cn.liuyiyou.yishop.entity.LoginLog;
import cn.liuyiyou.yishop.service.LoginLogService;
import cn.liuyiyou.yishop.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class LoginManager {

    @Autowired
    private LoginService loginService;

    @Autowired
    private LoginLogService loginLogService;

    public void txLogin(LoginInfo loginInfo, String loginIp, String loginAddress) {
        Date date = new Date();
        loginService.modifyLastLoginTime(loginInfo.getId(), date);

        LoginLog loginLog = new LoginLog();
        loginLog.setLoginAddress(loginAddress);
        loginLog.setLoginId(loginInfo.getId());
        loginLog.setLoginIp(loginIp);
        loginLog.setLoginTime(date);
        loginLog.setLoginType(loginInfo.getLoginType());
        loginLog.setUserId(loginInfo.getUserId());

        loginLogService.add(loginLog);
    }

}
