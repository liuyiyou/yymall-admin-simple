package cn.liuyiyou.shop.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/***
 * @author: liuyiyou
 * @date: 2018/5/28
 */
@Data
@ConfigurationProperties(prefix = "audience")
@Component
public class LoginParam {

    private String clientId;
    private String userName;
    private String password;
    private String captchaCode;
    private String captchaValue;
}
