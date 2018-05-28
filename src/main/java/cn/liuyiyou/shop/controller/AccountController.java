package cn.liuyiyou.shop.controller;

import cn.liuyiyou.shop.config.JwtProperty;
import cn.liuyiyou.shop.entity.User;
import cn.liuyiyou.shop.resp.Result;
import cn.liuyiyou.shop.resp.ResultGenerator;
import cn.liuyiyou.shop.resp.ResultStatusCode;
import cn.liuyiyou.shop.utils.JwtHelper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/***
 * @author: liuyiyou
 * @date: 2018/5/28
 */
@RestController
public class AccountController {


    @Autowired
    private JwtProperty jwtProperty;


    @ApiOperation(value = "使用JWT进行token验证，传入登录参数")
    @RequestMapping(value = "/accountLogin", method = RequestMethod.POST)
    public Result getAccessToken(@RequestParam("phone") String accountName,
                                 @RequestParam("psd") String accountPwd,
                                 @RequestParam("_token") String clientId, String mobileType, String deviceToken) {

        Result result = new Result();
        try {
            if (clientId == null || (clientId.compareTo(jwtProperty.getClientId()) != 0)) {
                result.setCode(ResultStatusCode.INVALID_CLIENTID.getErrorCode());
                result.setMessage(ResultStatusCode.INVALID_CLIENTID.getErrorMsg());
                return result;
            }

            User user = new User();
            try {
//                user = userService.login(accountName, accountPwd, logonMode);
//                accountService.updateLogin(accountName, mobileType, deviceToken);
            } catch (Exception e) {
                return ResultGenerator.genBadReqResult("用户名或密码不存在");
            }

            // 拼装accessToken
            String accessToken = JwtHelper.createJWT(accountName, user.getId(), "userRole", jwtProperty.getClientId(),
                    jwtProperty.getName(), jwtProperty.getExpiresSecond() * 1000, jwtProperty.getBase64Secret());


            Map map = new HashMap<>();
            map.put("accessToken", "bearer;" + accessToken);
            map.put("userId", user.getId());
            map.put("realName", user.getRealName());
            map.put("phoneNo", user.getPhoneNo());
            map.put("accountName", user.getAccountName());
            map.put("avatar", user.getAvatar());

            result.setCode(ResultStatusCode.OK.getErrorCode());
            result.setMessage(ResultStatusCode.OK.getErrorMsg());
            result.setData(map);
            return result;
        } catch (Exception ex) {

            result.setCode(ResultStatusCode.SYSTEM_ERR.getErrorCode());
            result.setMessage(ResultStatusCode.SYSTEM_ERR.getErrorMsg());
            return result;
        }
    }
}
