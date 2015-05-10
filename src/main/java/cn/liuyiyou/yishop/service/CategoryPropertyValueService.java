/**
 * 
 * 惠购 - 惠购网 - www.huiget.com - 特别会购！
 * Copyright © 2014 惠购 www.huiget.com 版权所有
 */
package cn.liuyiyou.yishop.service;

import cn.liuyiyou.yishop.mapper.BaseMapper;
import cn.liuyiyou.yishop.mapper.CategoryPropertyValueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author yaofang
 * @version $Id: CategoryPropertyValueService.java, v 0.1 2014年9月25日 下午6:07:04 yaofang Exp $
 */
@Service
public class CategoryPropertyValueService extends BaseSevice {

    @Autowired
    private CategoryPropertyValueMapper categoryPropertyValueMapper;


    @Override
    protected BaseMapper getMapper() {
        return categoryPropertyValueMapper;
    }

}
