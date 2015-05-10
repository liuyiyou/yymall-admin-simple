/**
 * 
 * 惠购 - 惠购网 - www.huiget.com - 特别会购！
 * Copyright © 2014 惠购 www.huiget.com 版权所有
 */
package cn.liuyiyou.yishop.mapper;

import cn.liuyiyou.yishop.entity.Meta;

/**
 * 
 * @author yaofang
 * @version $Id: MetaInfoMapper.java, v 0.1 2014年9月25日 下午2:36:54 yaofang Exp $
 */
public interface MetaMapper extends BaseMapper {

    public Meta queryByUri(String uri);

}
