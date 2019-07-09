package cn.liuyiyou.shop.system.mapper;

import cn.liuyiyou.shop.system.entity.SysDept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2018-08-27
 */
@Repository
public interface SysDeptMapper extends BaseMapper<SysDept> {

    int selectDeptCount(SysDept dept);

    int checkDeptExistUser(Integer deptId);

    SysDept checkDeptNameUnique(String deptName);

    SysDept selectDeptById(Integer parentId);
}
