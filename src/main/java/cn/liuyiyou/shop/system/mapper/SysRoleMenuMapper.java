package cn.liuyiyou.shop.system.mapper;

import cn.liuyiyou.shop.system.entity.SysRoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 角色和菜单关联表 Mapper 接口
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2018-08-27
 */
@Repository
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

    int selectCountRoleMenuByMenuId(Integer menuId);

    int batchRoleMenu(List<SysRoleMenu> list);

    void deleteRoleMenuByRoleId(Integer roleId);
}
