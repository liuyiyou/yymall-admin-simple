package cn.liuyiyou.shop.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/***
 * @author: liuyiyou
 * @date: 2018/5/28
 */
@ConfigurationProperties(prefix = "jwt.exclude")
public class JwtPatternUrl {
    private List<String> urlPatterns;

    public List<String> getUrlPatterns() {
        return urlPatterns;
    }

    public void setUrlPatterns(List<String> urlPatterns) {
        this.urlPatterns = urlPatterns;
    }
}
