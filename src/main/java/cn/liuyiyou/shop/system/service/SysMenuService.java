package cn.liuyiyou.shop.system.service;

import cn.liuyiyou.shop.system.entity.SysMenu;
import cn.liuyiyou.shop.system.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2018-08-27
 */
public interface SysMenuService extends IService<SysMenu> {

    List<SysMenu> selectMenusByUserId(Integer userId);


    Set<String> selectPermsByUserId(Integer userId);

    /**
     * 根据角色ID查询菜单
     *
     * @param role 角色对象
     * @return 菜单列表
     */
    List<Map<String, Object>> roleMenuTreeData(SysRole role);

    String checkMenuNameUnique(SysMenu menu);

    /**
     * 查询所有菜单信息
     *
     * @return 菜单列表
     */
    List<Map<String, Object>> menuTreeData();

    List<SysMenu> selectMenuAll();

    int selectCountMenuByParentId(Integer menuId);

    int selectCountRoleMenuByMenuId(Integer menuId);

    SysMenu selectMenuContainParentNameById(Integer menuId);
}
