package cn.liuyiyou.shop.system.service.impl;

import cn.liuyiyou.shop.system.constans.UserConstants;
import cn.liuyiyou.shop.system.entity.SysRole;
import cn.liuyiyou.shop.system.entity.SysRoleMenu;
import cn.liuyiyou.shop.system.mapper.SysRoleMapper;
import cn.liuyiyou.shop.system.mapper.SysRoleMenuMapper;
import cn.liuyiyou.shop.system.mapper.SysUserRoleMapper;
import cn.liuyiyou.shop.system.service.ISysRoleService;
import cn.liuyiyou.shop.system.utils.CurrentUserUtil;
import cn.liuyiyou.shop.system.utils.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2018-08-27
 */
@Service
@Transactional
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public List<SysRole> selectRolesByUserId(Integer userId) {
        List<SysRole> userRoles = sysRoleMapper.selectRolesByUserId(userId);
        List<SysRole> roles = this.list(null);
        for (SysRole role : roles) {
            for (SysRole userRole : userRoles) {
                if (role.getRoleId() == userRole.getRoleId()) {
                    role.setFlag(true);
                    break;
                }
            }
        }
        return roles;
    }

    @Override
    public Set<String> selectRoleKeys(Integer userId) {
        List<SysRole> perms = sysRoleMapper.selectRolesByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        for (SysRole perm : perms) {
            if (StringUtils.isNotNull(perms)) {
                permsSet.addAll(Arrays.asList(perm.getRoleKey().trim().split(",")));
            }
        }
        return permsSet;
    }

    @Override
    public Integer selectCountUserRoleByRoleId(Integer roleId) {
        return sysUserRoleMapper.selectCountUserRoleByRoleId(roleId);
    }

    /**
     * 保存角色信息
     *
     * @param role 角色信息
     * @return 结果
     */
    @Override
    public int editRole(SysRole role) {
        Integer roleId = role.getRoleId();
        role.setUpdateBy(CurrentUserUtil.getLoginName());
        sysRoleMapper.updateById(role);
        sysRoleMenuMapper.deleteRoleMenuByRoleId(roleId);
        return insertRoleMenu(role);
    }

    @Override
    public int addRole(SysRole role) {
        role.setCreateBy(CurrentUserUtil.getLoginName());
        sysRoleMapper.insert(role);
        return insertRoleMenu(role);
    }

    /**
     * 新增角色菜单信息
     *
     * @param sysRole 角色对象
     */
    public int insertRoleMenu(SysRole sysRole) {
        int rows = 1;
        List<SysRoleMenu> list = new ArrayList<>();
        for (Integer menuId : sysRole.getMenuIds()) {
            SysRoleMenu rm = new SysRoleMenu();
            rm.setRoleId(sysRole.getRoleId());
            rm.setMenuId(menuId);
            list.add(rm);
        }
        if (list.size() > 0) {
            rows = sysRoleMenuMapper.batchRoleMenu(list);
        }
        return rows;
    }

    @Override
    public String checkRoleNameUnique(SysRole role) {
        if (role.getRoleId() == null) {
            role.setRoleId(-1);
        }
        Integer roleId = role.getRoleId();
        SysRole info = sysRoleMapper.checkRoleNameUnique(role.getRoleName());
        if (StringUtils.isNotNull(info) && StringUtils.isNotNull(info.getRoleId()) && info.getRoleId() != roleId) {
            return UserConstants.ROLE_NAME_NOT_UNIQUE;
        }
        return UserConstants.ROLE_NAME_UNIQUE;
    }
}
