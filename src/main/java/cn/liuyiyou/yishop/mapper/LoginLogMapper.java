/**
 * 
 * 惠购 - 惠购网 - www.huiget.com - 特别会购！
 * Copyright © 2014 惠购 www.huiget.com 版权所有
 */
package cn.liuyiyou.yishop.mapper;

import cn.liuyiyou.yishop.entity.LoginLog;

import java.util.List;

/**
 * 
 * @author yaofang
 * @version $Id: LoginLogMapper.java, v 0.1 2014年10月4日 下午7:21:38 yaofang Exp $
 */
public interface LoginLogMapper extends BaseMapper {

    public int countByUserId(int userId);

    public List<LoginLog> queryByUserId(int userId);

}
