/**
 * 
 * 惠购 - 惠购网 - www.huiget.com - 特别会购！
 * Copyright © 2014 惠购 www.huiget.com 版权所有
 */
package cn.liuyiyou.yishop.service;

import cn.liuyiyou.yishop.entity.SystemParameter;
import cn.liuyiyou.yishop.mapper.BaseMapper;
import cn.liuyiyou.yishop.mapper.SystemParameterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * @author yaofang
 * @version $Id: SystemParameterService.java, v 0.1 2014年9月23日 下午6:01:54 yaofang Exp $
 */
@Service
public class SystemParameterService extends BaseSevice {

    @Autowired
    private SystemParameterMapper systemParameterMapper;

    public int countByParamType(String paramType) {
        return systemParameterMapper.countByParamType(paramType);
    }

    public List<SystemParameter> findByParamTypeAndStatus(String paramType, String status) {
        return systemParameterMapper.queryByParamTypeAndStatus(paramType, status);
    }

    public SystemParameter findByParamTypeAndParamKey(String paramType, String paramKey) {
        return systemParameterMapper.queryByParamTypeAndParamKey(paramType, paramKey);
    }

    public List<SystemParameter> findSystemParameters(String paramType, int pageSize, int pageNumber) {
        return systemParameterMapper.queryByParamTypeForPage(paramType, (pageNumber - 1) * pageSize, pageSize);
    }


    @Override
    protected BaseMapper getMapper() {
        return systemParameterMapper;
    }

}
