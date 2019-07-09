package cn.liuyiyou.shop.system.mapper;

import cn.liuyiyou.shop.system.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2018-08-27
 */
@Repository
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> selectMenusByUserId(Integer userId);

    List<String> selectPermsByUserId(Integer userId);

    /**
     * 查询系统所有菜单
     *
     * @return 菜单列表
     */
    List<SysMenu> selectMenuAll();

    /**
     * 根据角色ID查询菜单
     *
     * @param roleId 角色ID
     * @return 菜单列表
     */
    List<String> selectMenuTree(Integer roleId);

    SysMenu checkMenuNameUnique(String menuName);

    int selectCountMenuByParentId(Integer parentId);

    SysMenu selectMenuContainParentNameById(Integer menuId);
}
