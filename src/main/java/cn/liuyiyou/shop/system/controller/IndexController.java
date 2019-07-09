package cn.liuyiyou.shop.system.controller;

import cn.liuyiyou.shop.config.YiAdminConfig;
import cn.liuyiyou.shop.system.entity.SysMenu;
import cn.liuyiyou.shop.system.entity.SysUser;
import cn.liuyiyou.shop.system.service.SysMenuService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


/**
 * 首页 业务处理
 *
 * @author ruoyi
 */
@Controller
public class IndexController {
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private cn.liuyiyou.shop.system.service.ISysUserService ISysUserService;

    @Autowired
    private YiAdminConfig yiAdminConfig;

    // 系统首页
    @GetMapping({"/", "/index"})
    public String index(Model model) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        LambdaQueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>().lambda().select()
                .eq(SysUser::getLoginName, userDetails.getUsername());
        SysUser user = ISysUserService.getOne(queryWrapper);
        List<SysMenu> menus = sysMenuService.selectMenusByUserId(user.getUserId());
        model.addAttribute("menus", menus);
        model.addAttribute("user", user);
        model.addAttribute("copyrightYear", yiAdminConfig.getCopyrightYear());
        return "index";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(Model model) {
        model.addAttribute("version", yiAdminConfig.getVersion());
        return "main";
    }

}
