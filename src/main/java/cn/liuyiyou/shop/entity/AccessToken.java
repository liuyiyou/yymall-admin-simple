package cn.liuyiyou.shop.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/***
 * JWT Token的返回结果
 * @author: liuyiyou
 * @date: 2018/5/28
 */
@Data
@ConfigurationProperties(prefix = "audience")
@Component
public class AccessToken {

    private String accessToken;
    private String tokenType;
    private long expiresIn;
    private String userId;
}
