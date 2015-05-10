/**
 * 
 * 惠购 - 惠购网 - www.huiget.com - 特别会购！
 * Copyright © 2014 惠购 www.huiget.com 版权所有
 */
package cn.liuyiyou.yishop.service;

import cn.liuyiyou.yishop.entity.Category;
import cn.liuyiyou.yishop.mapper.BaseMapper;
import cn.liuyiyou.yishop.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * @author yaofang
 * @version $Id: CategoryInfoService.java, v 0.1 2014年9月23日 下午5:44:47 yaofang Exp $
 */
@Service
public class CategoryService extends BaseSevice {

    @Autowired
    private CategoryMapper categoryInfoMapper;

    public int getNextId(int parentId) {

        return categoryInfoMapper.queryNextIdByParentId(parentId);

    }

    public Category findByNameUrl(String nameUrl) {
        return categoryInfoMapper.queryByNameUrl(nameUrl);
    }

    public List<Category> findByStatus(String status) {
        return categoryInfoMapper.queryByStatus(status);
    }

    public List<Category> findByParentIdAndStatus(int parentId, String status) {
        return categoryInfoMapper.queryByParentIdAndStatus(parentId, status);
    }

    public List<Category> findByLevelAndStatus(int level, String status) {
        return categoryInfoMapper.queryByLevelAndStatus(level, status);
    }


    @Override
    protected BaseMapper getMapper() {
        return categoryInfoMapper;
    }

}
