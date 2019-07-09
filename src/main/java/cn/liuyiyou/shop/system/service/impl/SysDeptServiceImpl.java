package cn.liuyiyou.shop.system.service.impl;

import cn.liuyiyou.shop.system.constans.UserConstants;
import cn.liuyiyou.shop.system.entity.SysDept;
import cn.liuyiyou.shop.system.mapper.SysDeptMapper;
import cn.liuyiyou.shop.system.service.ISysDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2018-08-27
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements ISysDeptService {

    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Override
    public int selectDeptCount(Integer parentId) {
        SysDept dept = new SysDept();
        dept.setParentId(parentId);
        return sysDeptMapper.selectDeptCount(dept);
    }

    @Override
    public boolean checkDeptExistUser(Integer deptId) {
        int result = sysDeptMapper.checkDeptExistUser(deptId);
        return result > 0 ? true : false;
    }

    @Override
    public String checkDeptNameUnique(SysDept dept) {
        if (dept.getDeptId() == null) {
            dept.setDeptId(-1);
        }
        Integer deptId = dept.getDeptId();
        SysDept info = sysDeptMapper.checkDeptNameUnique(dept.getDeptName());
        if (Objects.nonNull(info) && Objects.nonNull(info.getDeptId()) && info.getDeptId().longValue() != deptId.longValue()) {
            return UserConstants.DEPT_NAME_NOT_UNIQUE;
        }
        return UserConstants.DEPT_NAME_UNIQUE;
    }

    @Override
    public SysDept selectDeptById(Integer deptId) {
        return sysDeptMapper.selectDeptById(deptId);
    }

    @Override
    public List<Map<String, Object>> selectDeptTree() {
        List<Map<String, Object>> trees = new ArrayList<>();
        List<SysDept> deptList = sysDeptMapper.selectList(null);
        for (SysDept dept : deptList) {
            if (UserConstants.DEPT_NORMAL == dept.getStatus()) {
                Map<String, Object> deptMap = new HashMap<String, Object>();
                deptMap.put("id", dept.getDeptId());
                deptMap.put("pId", dept.getParentId());
                deptMap.put("name", dept.getDeptName());
                trees.add(deptMap);
            }
        }
        return trees;
    }
}
