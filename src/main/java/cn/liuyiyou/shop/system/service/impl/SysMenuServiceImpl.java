package cn.liuyiyou.shop.system.service.impl;

import cn.liuyiyou.shop.system.constans.UserConstants;
import cn.liuyiyou.shop.system.entity.SysMenu;
import cn.liuyiyou.shop.system.entity.SysRole;
import cn.liuyiyou.shop.system.mapper.SysMenuMapper;
import cn.liuyiyou.shop.system.mapper.SysRoleMenuMapper;
import cn.liuyiyou.shop.system.service.SysMenuService;
import cn.liuyiyou.shop.system.utils.StringUtils;
import cn.liuyiyou.shop.system.utils.TreeUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2018-08-27
 */
@Service
@Slf4j
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;


    @Override
    public List<SysMenu> selectMenusByUserId(Integer userId) {
        List<SysMenu> menus = sysMenuMapper.selectMenusByUserId(userId);
        List childPerms = TreeUtils.getChildPerms(menus, 0);
        return childPerms;

    }

    @Override
    public Set<String> selectPermsByUserId(Integer userId) {
        List<String> perms = sysMenuMapper.selectPermsByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        for (String pem : perms) {
            if (StringUtils.isNotEmpty(pem)) {
                permsSet.addAll(Arrays.asList(pem.trim().split(",")));
            }
        }
        return permsSet;
    }

    @Override
    public List<Map<String, Object>> roleMenuTreeData(SysRole role) {
        Integer roleId = role.getRoleId();
        List<Map<String, Object>> trees = new ArrayList<>();
        List<SysMenu> menuList = sysMenuMapper.selectMenuAll();
        if (StringUtils.isNotNull(roleId)) {
            List<String> roleMenuList = sysMenuMapper.selectMenuTree(roleId);
            trees = getTrees(menuList, true, roleMenuList, true);
        } else {
            trees = getTrees(menuList, false, null, true);
        }
        return trees;
    }

    /**
     * 对象转菜单树
     *
     * @param menuList     菜单列表
     * @param isCheck      是否需要选中
     * @param roleMenuList 角色已存在菜单列表
     * @param permsFlag    是否需要显示权限标识
     * @return
     */
    public List<Map<String, Object>> getTrees(List<SysMenu> menuList, boolean isCheck, List<String> roleMenuList,
                                              boolean permsFlag) {
        List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();
        for (SysMenu menu : menuList) {
            Map<String, Object> deptMap = new HashMap<String, Object>();
            deptMap.put("id", menu.getMenuId());
            deptMap.put("pId", menu.getParentId());
            deptMap.put("name", transMenuName(menu, roleMenuList, permsFlag));
            if (isCheck) {
                deptMap.put("checked", roleMenuList.contains(menu.getMenuId() + menu.getPerms()));
            } else {
                deptMap.put("checked", false);
            }
            trees.add(deptMap);
        }
        return trees;
    }

    public String transMenuName(SysMenu menu, List<String> roleMenuList, boolean permsFlag) {
        StringBuffer sb = new StringBuffer();
        sb.append(menu.getMenuName());
        if (permsFlag) {
            sb.append("<font color=\"#888\">&nbsp;&nbsp;&nbsp;" + menu.getPerms() + "</font>");
        }
        return sb.toString();
    }

    @Override
    public String checkMenuNameUnique(SysMenu menu) {
        if (menu.getMenuId() == null) {
            menu.setMenuId(-1);
        }
        Integer menuId = menu.getMenuId();
        SysMenu info = sysMenuMapper.checkMenuNameUnique(menu.getMenuName());
        if (StringUtils.isNotNull(info) && StringUtils.isNotNull(info.getMenuId())
                && info.getMenuId().longValue() != menuId.longValue()) {
            return UserConstants.MENU_NAME_NOT_UNIQUE;
        }
        return UserConstants.MENU_NAME_UNIQUE;
    }

    @Override
    public List<Map<String, Object>> menuTreeData() {
        List<SysMenu> menuList = sysMenuMapper.selectMenuAll();
        List<Map<String, Object>> trees = getTrees(menuList, false, null, false);
        return trees;
    }

    @Override
    public List<SysMenu> selectMenuAll() {
        List<SysMenu> allMenus = sysMenuMapper.selectMenuAll();
        return allMenus;
    }

    @Override
    public int selectCountMenuByParentId(Integer parentId) {
        return sysMenuMapper.selectCountMenuByParentId(parentId);
    }

    @Override
    public int selectCountRoleMenuByMenuId(Integer menuId) {
        return sysRoleMenuMapper.selectCountRoleMenuByMenuId(menuId);
    }

    @Override
    public SysMenu selectMenuContainParentNameById(Integer menuId) {
        return sysMenuMapper.selectMenuContainParentNameById(menuId);
    }
}
