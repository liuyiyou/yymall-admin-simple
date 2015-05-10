/**
 * 
 * 惠购 - 惠购网 - www.huiget.com - 特别会购！
 * Copyright © 2014 惠购 www.huiget.com 版权所有
 */
package cn.liuyiyou.yishop.service;

import cn.liuyiyou.yishop.mapper.AuthMapper;
import cn.liuyiyou.yishop.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author yaofang
 * @version $Id: AuthInfoService.java, v 0.1 2014年9月25日 下午6:04:16 yaofang Exp $
 */
@Service
public class AuthService extends BaseSevice {

    @Autowired
    private AuthMapper authInfoMapper;


    @Override
    protected BaseMapper getMapper() {
        return authInfoMapper;
    }

}
