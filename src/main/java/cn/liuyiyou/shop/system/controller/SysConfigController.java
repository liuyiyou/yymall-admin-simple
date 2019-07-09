package cn.liuyiyou.shop.system.controller;


import cn.liuyiyou.yiadmin.entity.SysConfig;
import cn.liuyiyou.yiadmin.service.SysConfigService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 * 参数配置表 前端控制器
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2018-08-27
 */
@Controller
@RequestMapping("/system/config")
public class SysConfigController {


    private String prefix = "system/config";

    @ApiOperation(value = "跳转到用户列表页面")
    @GetMapping()
    @PreAuthorize("hasAuthority('system:user:view')")
    public ModelAndView config() {
        return new ModelAndView(prefix + "/config");
    }


    @Autowired
    private SysConfigService sysConfigService;

    @PostMapping("list")
    public List<SysConfig> list() {
        QueryWrapper<SysConfig> queryWrapper = new QueryWrapper<SysConfig>().select("*");
        List<SysConfig> list = sysConfigService.list(queryWrapper);
        return list;
    }

}

