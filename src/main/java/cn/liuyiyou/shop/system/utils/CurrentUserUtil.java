package cn.liuyiyou.shop.system.utils;

import cn.liuyiyou.shop.system.entity.SysUser;
import cn.liuyiyou.shop.system.service.ISysUserService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

/**
 * 这不是最好的处理方法，因为查询了一遍数据库
 *
 * @author: liuyiyou
 * @date: 2018/10/9
 * @version: V1.0
 * @Copyright: 2018 liuyiyou.cn Inc. All rights reserved.
 */
@Component
public class CurrentUserUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    public static SysUser getLoginUser() {
        ISysUserService sys = applicationContext.getBean(ISysUserService.class);
        SysUser sysUser = sys.selectUserByLoginName(getUser().getUsername());
        return sysUser;
    }

    public static String getLoginName() {
        return getLoginUser().getLoginName();
    }


    public static User getUser() {
        User principal = (User) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return principal;
    }

    public static Integer getLoginUserId() {
        return getLoginUser().getUserId();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CurrentUserUtil.applicationContext = applicationContext;
    }
}
