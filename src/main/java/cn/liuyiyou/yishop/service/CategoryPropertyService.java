/**
 * 
 * 惠购 - 惠购网 - www.huiget.com - 特别会购！
 * Copyright © 2014 惠购 www.huiget.com 版权所有
 */
package cn.liuyiyou.yishop.service;

import cn.liuyiyou.yishop.mapper.BaseMapper;
import cn.liuyiyou.yishop.mapper.CategoryPropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author yaofang
 * @version $Id: CategoryPropertyService.java, v 0.1 2014年9月25日 下午6:06:12 yaofang Exp $
 */
@Service
public class CategoryPropertyService extends BaseSevice {

    @Autowired
    private CategoryPropertyMapper categoryPropertyMapper;


    @Override
    protected BaseMapper getMapper() {
        return categoryPropertyMapper;
    }

}
