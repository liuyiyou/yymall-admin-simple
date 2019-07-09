package cn.liuyiyou.shop.system.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 岗位信息表 前端控制器
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2018-08-27
 */
@Controller
@RequestMapping("/system/post")
public class SysPostController {


    private String prefix = "system/post";


    //    @RequiresPermissions("system:menu:view")
    @GetMapping()
    public String menu() {
        return prefix + "/post";
    }

}

