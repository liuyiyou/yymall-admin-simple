package cn.liuyiyou.shop.system.service.impl;

import cn.liuyiyou.shop.system.constans.UserConstants;
import cn.liuyiyou.shop.system.entity.SysUser;
import cn.liuyiyou.shop.system.entity.SysUserRole;
import cn.liuyiyou.shop.system.mapper.SysUserMapper;
import cn.liuyiyou.shop.system.mapper.SysUserRoleMapper;
import cn.liuyiyou.shop.system.service.ISysUserService;
import cn.liuyiyou.shop.system.utils.CurrentUserUtil;
import cn.liuyiyou.shop.system.utils.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.Arrays;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2018-08-27
 */
@Service
@Transactional
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;


    @Override
    public SysUser selectUserInfoByUserId(Integer userId) {
        return sysUserMapper.selectUserInfoByUserId(userId);
    }

    @Override
    public SysUser selectUserByLoginName(String loginName) {
        return sysUserMapper.selectUserByLoginName(loginName);
    }


    @Override
    public IPage<SysUser> selectUserList(Page<SysUser> page, SysUser sysUser) {
        return sysUserMapper.selectUserList(page, sysUser);
    }


    @Override
    public boolean addUserAndRoles(SysUser sysUser) {
        sysUser.setCreateBy(CurrentUserUtil.getUser().getUsername())
                .setUpdateBy(CurrentUserUtil.getUser().getUsername());
        this.save(sysUser);
        updateRoles(sysUser);
        return true;
    }

    @Override
    public boolean updateUserAndRoles(SysUser sysUser) {
        sysUser.setUpdateBy(CurrentUserUtil.getUser().getUsername());
        this.updateById(sysUser);
        updateRoles(sysUser);
        return true;

    }

    @Override
    public boolean delete(SysUser sysUser) {
        sysUser.setStatus(1);
        sysUserRoleMapper.deleteUserRoleByUserId(sysUser.getUserId());
        this.updateById(sysUser);
        return true;
    }

    private void updateRoles(@NotNull SysUser sysUser) {
        sysUserRoleMapper.delete(new QueryWrapper<SysUserRole>()
                .lambda()
                .eq(SysUserRole::getUserId, sysUser.getUserId())
        );
        Arrays.asList(sysUser.getRoleIds()).forEach(roleId -> {
            SysUserRole sysUserRole = new SysUserRole().setUserId(sysUser.getUserId()).setRoleId(roleId);
            sysUserRoleMapper.insert(sysUserRole);
        });
    }


    @Override
    public int batchDeleteUser(Long[] ids) {
        return 0;
    }


    @Override
    public String checkLoginNameUnique(String loginName) {
        int count = sysUserMapper.checkLoginNameUnique(loginName);
        if (count > 0) {
            return UserConstants.USER_NAME_NOT_UNIQUE;
        }
        return UserConstants.USER_NAME_UNIQUE;
    }


    @Override
    public String checkEmailUnique(SysUser user) {
        if (user.getUserId() == null) {
            user.setUserId(-1);
        }
        Integer userId = user.getUserId();
        SysUser info = sysUserMapper.checkEmailUnique(user.getEmail());
        if (StringUtils.isNotNull(info) && StringUtils.isNotNull(info.getUserId())
                && info.getUserId().longValue() != userId.longValue()) {
            return UserConstants.USER_EMAIL_NOT_UNIQUE;
        }
        return UserConstants.USER_EMAIL_UNIQUE;
    }

    @Override
    public String checkPhoneUnique(SysUser user) {
        if (user.getUserId() == null) {
            user.setUserId(-1);
        }
        Integer userId = user.getUserId();
        SysUser info = sysUserMapper.checkPhoneUnique(user.getPhonenumber());
        if (StringUtils.isNotNull(info) && StringUtils.isNotNull(info.getUserId())
                && info.getUserId().longValue() != userId.intValue()) {
            return UserConstants.USER_PHONE_NOT_UNIQUE;
        }
        return UserConstants.USER_PHONE_UNIQUE;
    }


    @Override
    public int resetUserPwd(SysUser user) {
        return 0;
    }
}
