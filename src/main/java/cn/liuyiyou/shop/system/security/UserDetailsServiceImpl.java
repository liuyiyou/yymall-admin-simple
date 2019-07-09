package cn.liuyiyou.shop.system.security;

import cn.liuyiyou.shop.system.entity.SysUser;
import cn.liuyiyou.shop.system.service.ISysUserService;
import cn.liuyiyou.shop.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

/*
 * @author: liuyiyou
 * @date: 2018/8/27
 * @version: V1.0
 * @Copyright: 2018 liuyiyou.cn Inc. All rights reserved.
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.selectUserByLoginName(username);
        User.UserBuilder builder = User.builder().username(username).password(sysUser.getPassword());
        Set<String> permsissions = sysMenuService.selectPermsByUserId(sysUser.getUserId());
        List<GrantedAuthority> grantedAuthorities = permsissions.stream().map(SimpleGrantedAuthority::new).collect(toList());
        builder.authorities(grantedAuthorities);
        return builder.build();
    }
}
