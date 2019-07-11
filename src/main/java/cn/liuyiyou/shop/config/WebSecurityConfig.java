package cn.liuyiyou.shop.config;

import cn.liuyiyou.shop.system.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*
 *
 * @author: liuyiyou
 * @date: 2018/8/27
 * @version: V1.0
 * @Copyright: 2018 liuyiyou.cn Inc. All rights reserved.
 */
//开启SpringSecurity功能
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService); //user Details Service验证
    }

    /**
     * 通过authorizeRequests()定义哪些需要被保护，哪些不需要保护
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/*.ico", "/css/**", "/js/**", "/images/**", "/fonts/**", "/bootstrap/**", "/jquery/**", "/ajax/**", "/ruoyi/**", "/img/**", "/png/**")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").failureUrl("/login-error")
                .permitAll() //这个不能去掉，不然会一直重定向
                .defaultSuccessUrl("/") //登陆成功后跳转的页面
                .and().csrf().disable()
                .headers().frameOptions().sameOrigin(); //X-Frame-Options' to 'deny; iframe 访问
    }


    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


}
