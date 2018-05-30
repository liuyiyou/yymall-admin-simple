//package cn.liuyiyou.shop.service.impl;
//
//import cn.liuyiyou.shop.entity.Member;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//
///***
// * @author: liuyiyou
// * @date: 2018/5/28
// */
//@Service
//public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {
//
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        Member member = Member.builder().accountName("18600774073").pwd("123456").build();
//        return new org.springframework.security.core.userdetails.User(member.getAccountName(), member.getPwd(), Collections.EMPTY_LIST);
//    }
//}
