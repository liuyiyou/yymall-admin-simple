package cn.liuyiyou.shop.system.controller;


import cn.liuyiyou.yiadmin.annotation.Log;
import cn.liuyiyou.yiadmin.entity.SysMenu;
import cn.liuyiyou.yiadmin.entity.SysRole;
import cn.liuyiyou.yiadmin.result.Response;
import cn.liuyiyou.yiadmin.result.Result;
import cn.liuyiyou.yiadmin.service.SysMenuService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Api(description = "菜单管理相关接口")
@Controller
@RequestMapping("/system/menu")
public class SysMenuController {


    private String prefix = "system/menu";


    @Autowired
    private SysMenuService sysMenuService;

    //    @RequiresPermissions("system:menu:view")
    @GetMapping()
    public String menu() {
        return prefix + "/menu";
    }

    //    @RequiresPermissions("system:menu:list")
    @GetMapping("/list")
    @ResponseBody
    public List<SysMenu> list() {
        List<SysMenu> menuList = sysMenuService.selectMenuAll();
        return menuList;
    }

    /**
     * 删除菜单
     */
    @Log(title = "系统管理", action = "菜单管理-删除菜单")
//    @RequiresPermissions("system:menu:remove")
    @GetMapping("/remove/{menuId}")
    @ResponseBody
    public Result<Boolean> remove(@PathVariable("menuId") Integer menuId) {
        if (sysMenuService.selectCountMenuByParentId(menuId) > 0) {
            return Response.fail(1, "存在子菜单,不允许删除");
        }
        if (sysMenuService.selectCountRoleMenuByMenuId(menuId) > 0) {
            return Response.fail(1, "菜单已分配,不允许删除");
        }
        if (sysMenuService.removeById(menuId)) {
            return Response.success();
        }
        return Response.fail();
    }

    /**
     * 修改菜单
     */
    @Log(title = "系统管理", action = "菜单管理-修改菜单")
//    @RequiresPermissions("system:menu:edit")
    @GetMapping("/edit/{menuId}")
    public String edit(@PathVariable("menuId") Integer menuId, Model model) {
        SysMenu menu = sysMenuService.selectMenuContainParentNameById(menuId);
        model.addAttribute("menu", menu);
        return prefix + "/edit";
    }

    /**
     * 新增
     */
    @Log(title = "系统管理", action = "菜单管理-新增菜单")
//    @RequiresPermissions("system:menu:add")
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable("parentId") Long parentId, Model model) {
        SysMenu menu;
        if (0L != parentId) {
            menu = sysMenuService.getById(parentId);
        } else {
            menu = new SysMenu();
            menu.setMenuId(0);
            menu.setMenuName("主目录");
        }
        model.addAttribute("menu", menu);
        return prefix + "/add";
    }

    /**
     * 保存菜单
     */
    @Log(title = "系统管理", action = "菜单管理-保存菜单")
//    @RequiresPermissions("system:menu:save")
    @PostMapping("/save")
    @ResponseBody
    public Result<Object> save(SysMenu menu) {
        if (sysMenuService.saveOrUpdate(menu)) {
            return Response.success();
        }
        return Response.fail();
    }

    /**
     * 选择菜单图标
     */
    @GetMapping("/icon")
    public String icon() {
        return prefix + "/icon";
    }

    /**
     * 校验菜单名称
     */
    @PostMapping("/checkMenuNameUnique")
    @ResponseBody
    public String checkMenuNameUnique(SysMenu menu) {
        String uniqueFlag = "0";
        if (menu != null) {
            uniqueFlag = sysMenuService.checkMenuNameUnique(menu);
        }
        return uniqueFlag;
    }

    /**
     * 加载所有菜单列表树
     */
    @GetMapping("/menuTreeData")
    @ResponseBody
    public List<Map<String, Object>> menuTreeData(SysRole role) {
        List<Map<String, Object>> tree = sysMenuService.menuTreeData();
        return tree;
    }

    /**
     * 选择菜单树
     */
    @GetMapping("/selectMenuTree/{menuId}")
    public String selectMenuTree(@PathVariable("menuId") Long menuId, Model model) {
        model.addAttribute("treeName", sysMenuService.getById(menuId).getMenuName());
        return prefix + "/tree";
    }

    /**
     * 加载角色菜单列表树
     */
    @GetMapping("/roleMenuTreeData")
    @ResponseBody
    public List<Map<String, Object>> roleMenuTreeData(SysRole role) {
        List<Map<String, Object>> tree = sysMenuService.roleMenuTreeData(role);
        return tree;
    }
}

