/**
 * 
 * 惠购 - 惠购网 - www.huiget.com - 特别会购！
 * Copyright © 2014 惠购 www.huiget.com 版权所有
 */
package cn.liuyiyou.yishop.mapper;

import cn.liuyiyou.yishop.entity.Channel;

import java.util.List;

/**
 * 
 * @author yaofang
 *
 * @version $Id: ChannelMapper.java, v 0.1 2014年10月24日 下午8:38:27 yaofang Exp $
 */
public interface ChannelMapper extends BaseMapper {

    List<Channel> queryByStatus(String status);

}
