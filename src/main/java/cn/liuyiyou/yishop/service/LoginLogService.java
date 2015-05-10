/**
 * 
 * 惠购 - 惠购网 - www.huiget.com - 特别会购！
 * Copyright © 2014 惠购 www.huiget.com 版权所有
 */
package cn.liuyiyou.yishop.service;

import cn.liuyiyou.yishop.entity.LoginLog;
import cn.liuyiyou.yishop.mapper.BaseMapper;
import cn.liuyiyou.yishop.mapper.LoginLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * @author yaofang
 * @version $Id: LoginLogService.java, v 0.1 2014年10月4日 下午7:25:05 yaofang Exp $
 */
@Service
public class LoginLogService extends BaseSevice {

    @Autowired
    private LoginLogMapper loginLogMapper;

    public List<LoginLog> findLoginLogByUserId(int userId) {
        return loginLogMapper.queryByUserId(userId);
    }

    public int countByUserId(int userId) {
        return loginLogMapper.countByUserId(userId);
    }


    @Override
    protected BaseMapper getMapper() {
        return loginLogMapper;
    }

}
