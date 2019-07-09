package cn.liuyiyou.shop.system.service;

import cn.liuyiyou.shop.system.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 角色信息表 服务类
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2018-08-27
 */
public interface ISysRoleService extends IService<SysRole> {

    List<SysRole> selectRolesByUserId(Integer userId);

    /**
     * 根据用户ID查询角色
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    Set<String> selectRoleKeys(Integer userId);




    /**
     * 保存角色信息
     *
     * @param role 角色信息
     * @return 结果
     */
    int addRole(SysRole role);

    /**
     * 修改角色信息
     *
     * @param role 角色信息
     * @return 结果
     */
    int editRole(SysRole role);

    /**
     * 通过角色ID查询角色使用数量
     *
     * @param roleId 角色ID
     * @return 结果
     */
    Integer selectCountUserRoleByRoleId(Integer roleId);

    /**
     * 校验角色名称是否唯一
     *
     * @param role 角色信息
     * @return 结果
     */
    String checkRoleNameUnique(SysRole role);
}
