package cn.liuyiyou.shop.system.service;

import cn.liuyiyou.shop.system.entity.SysUser;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2018-08-27
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 根据条件分页查询用户对象
     * @param sysUser 用户信息
     * @return 用户信息集合信息
     */
    IPage<SysUser> selectUserList(Page<SysUser> page, SysUser sysUser);

    String checkEmailUnique(SysUser user);

    String checkPhoneUnique(SysUser user);

    int resetUserPwd(SysUser user);

    int batchDeleteUser(Long[] ids);

    String checkLoginNameUnique(String loginName);


    SysUser selectUserInfoByUserId(Integer userId);


    SysUser selectUserByLoginName(String loginName);

    boolean updateUserAndRoles(SysUser sysUser);

    boolean addUserAndRoles(SysUser sysUser);

    boolean delete(SysUser sysUser);
}
