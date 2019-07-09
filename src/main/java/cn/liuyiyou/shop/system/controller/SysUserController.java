package cn.liuyiyou.shop.system.controller;


import cn.liuyiyou.yiadmin.annotation.Log;
import cn.liuyiyou.yiadmin.entity.SysRole;
import cn.liuyiyou.yiadmin.entity.SysUser;
import cn.liuyiyou.yiadmin.result.Response;
import cn.liuyiyou.yiadmin.result.Result;
import cn.liuyiyou.yiadmin.service.ISysRoleService;
import cn.liuyiyou.yiadmin.service.ISysUserService;
import cn.liuyiyou.yiadmin.vo.req.user.SysUserListReqVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2018-08-27
 */
@RestController
@RequestMapping("/system/user")
@Api(description = "用户管理相关接口")
public class SysUserController {

    private String prefix = "system/user";

    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysRoleService sysRoleService;


    @ApiOperation(value = "跳转到用户列表页面")
    @GetMapping()
    @PreAuthorize("hasAuthority('system:user:view')")
    public ModelAndView list() {
        return new ModelAndView(prefix + "/user");
    }

    @ApiOperation(value = "跳转到新增用户页面")
    @GetMapping("/add")
    @PreAuthorize("hasAuthority('system:user:edit')")
    public ModelAndView add() {
        List<SysRole> roles = sysRoleService.list(null);
        ModelAndView mv = new ModelAndView();
        mv.addObject("roles", roles);
        mv.setViewName(prefix + "/add");
        return mv;
    }


    @ApiOperation(value = "跳转到修改用户页面")
    @PreAuthorize("hasAuthority('system:user:edit')")
    @Log(title = "系统管理", action = "用户管理-修改用户")
    @GetMapping("/edit/{userId}")
    public ModelAndView edit(@PathVariable("userId") Integer userId) {
        SysUser user = sysUserService.selectUserInfoByUserId(userId);
        List<SysRole> roles = sysRoleService.selectRolesByUserId(userId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("roles", roles);
        mv.addObject("user", user);
        mv.setViewName(prefix + "/edit");
        return mv;
    }


    @ApiOperation(value = "获取用户列表")
    @PostMapping()
    @PreAuthorize("hasAuthority('system:user:list')")
    public Result<IPage<SysUser>> list(@RequestBody SysUserListReqVo sysUserListReqVo) {
        Page<SysUser> pageQuery = new Page<>(sysUserListReqVo.getPageNum(), sysUserListReqVo.getPageSize());
        SysUser sysUserQuery = new SysUser()
                .setDeptId(sysUserListReqVo.getDeptId())
                .setParentId(sysUserListReqVo.getParentId());
        IPage<SysUser> sysUserPage = sysUserService.selectUserList(pageQuery, sysUserQuery);
        return Response.success(sysUserPage);
    }


    @ApiOperation(value = "保存用户")
    @Log(title = "系统管理", action = "用户管理-新增用户")
    @PutMapping("/add")
    @PreAuthorize("hasAuthority('system:user:add')")
    public Result<Boolean> add(@RequestBody SysUser sysUser) {
        if (!StringUtils.isEmpty(sysUser.getUserId()) && SysUser.isAdmin(sysUser.getUserId())) {
            return Response.fail("不允许修改超级管理员用户");
        }
        return sysUserService.addUserAndRoles(sysUser) ? Response.success() : Response.fail("修改用户失败");
    }


    @ApiOperation(value = "修改用户")
    @Log(title = "系统管理", action = "用户管理-修改用户")
    @PutMapping("/edit")
    @PreAuthorize("hasAuthority('system:user:edit')")
    public Result<Boolean> edit(@RequestBody SysUser sysUser) {
        if (!StringUtils.isEmpty(sysUser.getUserId()) && SysUser.isAdmin(sysUser.getUserId())) {
            return Response.fail("不允许修改超级管理员用户");
        }
        return sysUserService.updateUserAndRoles(sysUser) ? Response.success() : Response.fail("修改用户失败");
    }


    @Log(title = "系统管理", action = "用户管理-删除用户")
    @DeleteMapping("/{userId}")
    @ApiOperation(value = "删除用户")
    @PreAuthorize("hasAuthority('system:user:delete')")
    public Result<Boolean> remove(@PathVariable("userId") Integer userId) {
        SysUser sysUser = sysUserService.getById(userId);
        if (sysUser == null) {
            return Response.fail("用户不存在");
        } else if (SysUser.isAdmin(userId)) {
            return Response.fail("不允许删除超级管理员用户");
        }
        return Response.success(sysUserService.delete(sysUser));
    }


    @GetMapping("/resetPwd/{userId}")
    public String resetPwd(@PathVariable("userId") Integer userId, Model model) {
        SysUser user = sysUserService.getById(userId);
        model.addAttribute("user", user);
        return prefix + "/resetPwd";
    }

    @PostMapping("/resetPwd")
    @ResponseBody
    public Result<Boolean> resetPwd(SysUser user) {
        return Response.success(sysUserService.resetUserPwd(user) > 0);
    }


    //    @RequiresPermissions("system:user:batchRemove")
    @Log(title = "系统管理", action = "用户管理-批量删除")
    @PostMapping("/batchRemove")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public Result<Integer> batchRemove(@RequestParam("ids[]") Long[] ids) {
        return Response.success(sysUserService.batchDeleteUser(ids));
    }


    /**
     * 校验用户名
     */
    @PostMapping("/checkLoginNameUnique")
    @ResponseBody
    public String checkLoginNameUnique(SysUser user) {
        String uniqueFlag = "0";
        if (user != null) {
            uniqueFlag = sysUserService.checkLoginNameUnique(user.getLoginName());
        }
        return uniqueFlag;
    }

    /**
     * 校验手机号码
     */
    @PostMapping("/checkPhoneUnique")
    @ResponseBody
    public String checkPhoneUnique(SysUser user) {
        String uniqueFlag = "0";
        if (user != null) {
            uniqueFlag = sysUserService.checkPhoneUnique(user);
        }
        return uniqueFlag;
    }

    /**
     * 校验手机号码
     */
    @PostMapping("/checkEmailUnique")
    @ResponseBody
    public String checkEmailUnique(SysUser user) {
        String uniqueFlag = "0";
        if (user != null) {
            uniqueFlag = sysUserService.checkEmailUnique(user);
        }
        return uniqueFlag;
    }
}

