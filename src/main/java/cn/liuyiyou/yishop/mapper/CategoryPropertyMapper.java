/**
 * 
 * 惠购 - 惠购网 - www.huiget.com - 特别会购！
 * Copyright © 2014 惠购 www.huiget.com 版权所有
 */
package cn.liuyiyou.yishop.mapper;

import cn.liuyiyou.yishop.entity.CategoryProperty;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 
 * @author yaofang
 * @version $Id: CategoryPropertyMapper.java, v 0.1 2014年9月25日 下午4:58:48 yaofang Exp $
 */
public interface CategoryPropertyMapper extends BaseMapper {

    public List<CategoryProperty> queryByStatus(String status);

    public List<CategoryProperty> queryByCategoryIdAndStatus(@Param("categoryId") int categoryId, @Param("status") String status);

}
