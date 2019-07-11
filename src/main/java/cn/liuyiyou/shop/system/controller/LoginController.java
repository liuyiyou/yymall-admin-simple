package cn.liuyiyou.shop.system.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2018/8/24
 * @Copyright 2018 liuyiyou.cn Inc. All rights reserved
 */
@Controller
@Slf4j
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
//
//
//    @PostMapping("/login")
//    @ResponseBody
//    public String loginPost(String username,String password) {
//        return "login";
//    }

    @GetMapping("/403")
    @ResponseBody
    public String _403() {
        return "没有权限";
    }

    @GetMapping("/login-error")
    public String loginError(Model model, HttpServletRequest request) {
        log.info("登陆错误......");
        model.addAttribute("loginError", true);
        AuthenticationException exception = (AuthenticationException) request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        System.out.println(exception);
        return "login";
    }
}