package cn.liuyiyou.shop.system.service;

import cn.liuyiyou.shop.system.entity.SysDept;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2018-08-27
 */
public interface ISysDeptService extends IService<SysDept> {

    List<Map<String, Object>> selectDeptTree();

    /**
     * 查询部门人数
     *
     * @param parentId 父部门ID
     * @return 结果
     */
    int selectDeptCount(Integer parentId);

    /**
     * 查询部门是否存在用户
     *
     * @param deptId 部门ID
     * @return 结果 true 存在 false 不存在
     */
    boolean checkDeptExistUser(Integer deptId);

    /**
     * 校验部门名称是否唯一
     *
     * @param dept 部门信息
     * @return 结果
     */
    String checkDeptNameUnique(SysDept dept);
    /**
     * 根据部门ID查询信息
     *
     * @param deptId 部门ID
     * @return 部门信息
     */
    SysDept selectDeptById(Integer deptId);
}
