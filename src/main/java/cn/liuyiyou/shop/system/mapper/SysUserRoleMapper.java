package cn.liuyiyou.shop.system.mapper;

import cn.liuyiyou.shop.system.entity.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户和角色关联表 Mapper 接口
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2018-08-27
 */
@Repository
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    Integer selectCountUserRoleByRoleId(Integer roleId);

    Integer deleteUserRoleByUserId(Integer userId);
}
