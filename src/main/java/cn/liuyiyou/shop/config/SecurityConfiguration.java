//package cn.liuyiyou.shop.config;
//
//import cn.liuyiyou.shop.filter.JwtAuthenticationFilter;
//import cn.liuyiyou.shop.filter.JwtLoginFilter;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///***
// * @author: liuyiyou
// * @date: 2018/5/28
// */
//@Configuration
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable().authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .addFilter(new JwtLoginFilter(authenticationManager()))
//                .addFilter(new JwtAuthenticationFilter(authenticationManager()));
//    }
//
//}
