package cn.liuyiyou.shop.system.controller;


import cn.liuyiyou.shop.common.response.Response;
import cn.liuyiyou.shop.common.response.Result;
import cn.liuyiyou.shop.system.annotation.Log;
import cn.liuyiyou.shop.system.entity.SysRole;
import cn.liuyiyou.shop.system.service.ISysRoleService;
import cn.liuyiyou.shop.system.vo.req.DataTableVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Api(description = "用户管理相关接口")
@RestController
@RequestMapping("api/system/role")
public class SysRoleController {

    private String prefix = "system/role";

    @Autowired
    private ISysRoleService sysRoleService;

    @ApiOperation(value = "跳转到角色列表页面")
    @Log(title = "系统管理", action = "角色管理-新增角色页面")
    @PreAuthorize("hasAuthority('system:role:view')")
    @GetMapping()
    public ModelAndView get() {
        return new ModelAndView(prefix + "/role");
    }


    @ApiOperation(value = "跳转到新增角色页面")
    @Log(title = "系统管理", action = "角色管理-新增角色")
    @PreAuthorize("hasAuthority('system:role:add')")
    @GetMapping("/add")
    public ModelAndView add() {
        return new ModelAndView(prefix + "/add");
    }

    @ApiOperation(value = "跳转到新增角色页面")
    @Log(title = "系统管理", action = "角色管理-修改角色")
    @GetMapping("/edit/{roleId}")
    @PreAuthorize("hasAuthority('system:role:edit')")
    public ModelAndView edit(@PathVariable("roleId") Integer roleId) {
        ModelAndView mv = new ModelAndView(prefix + "/edit");
        SysRole role = sysRoleService.getById(roleId);
        mv.addObject("role", role);
        return mv;
    }


    @ApiOperation(value = "角色列表")
    @Log(title = "系统管理", action = "角色管理-角色列表")
    @PostMapping()
    @PreAuthorize("hasAuthority('system:role:view')")
    public Result<IPage<SysRole>> list(@RequestBody DataTableVo dataTableVo) {
        Page<SysRole> pageQuery = new Page<>(dataTableVo.getPageNo(), dataTableVo.getPageSize());
        LambdaQueryWrapper<SysRole> queryWrapper = new QueryWrapper<SysRole>().lambda().select();
        IPage<SysRole> page = sysRoleService.page(pageQuery, queryWrapper);
        return Response.success(page);
    }


    @ApiOperation(value = "新增角色")
    @Log(title = "系统管理", action = "角色管理-新增角色")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('system:role:add')")
    public Result<Boolean> save(SysRole role) {
        return Response.success(sysRoleService.addRole(role) > 0);
    }

    @ApiOperation(value = "跳转到新增角色页面")
    @Log(title = "系统管理", action = "角色管理-修改角色")
    @PutMapping("/edit")
    @PreAuthorize("hasAuthority('system:role:edit')")
    public Result<Boolean> edit(@RequestBody SysRole sysRole) {
        return Response.success(sysRoleService.editRole(sysRole) > 0);
    }

    @ApiOperation(value = "删除角色")
    @Log(title = "系统管理", action = "角色管理-删除角色")
    @DeleteMapping("/{roleId}")
    @PreAuthorize("hasAuthority('system:role:delete')")
    public Result<Boolean> remove(@PathVariable("roleId") Integer roleId) {
        SysRole sysRole = sysRoleService.getById(roleId);
        if (sysRole == null) {
            return Response.fail("角色不存在");
        }
        if (sysRoleService.selectCountUserRoleByRoleId(roleId) > 0) {
            return Response.fail("角色已分配,不能删除");
        }
        if (sysRoleService.removeById(roleId)) {
            return Response.success();
        }
        return Response.success(sysRoleService.removeById(roleId));
    }


    @Log(title = "系统管理", action = "角色管理-批量删除")
    @PostMapping("/batchRemove")
    public Result<Boolean> batchRemove(@RequestParam("ids[]") Integer[] ids) {
        return Response.success(sysRoleService.removeByIds(Arrays.asList(ids)));
    }

    /**
     * 校验角色名称
     */
    @PostMapping("/checkRoleNameUnique")
    public String checkRoleNameUnique(SysRole role) {
        String uniqueFlag = "0";
        if (role != null) {
            uniqueFlag = sysRoleService.checkRoleNameUnique(role);
        }
        return uniqueFlag;
    }

    /**
     * 选择菜单树
     */
    @GetMapping("/selectMenuTree")
    public String selectMenuTree() {
        return prefix + "/tree";
    }
}

