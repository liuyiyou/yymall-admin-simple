/**
 * 
 * 惠购 - 惠购网 - www.huiget.com - 特别会购！
 * Copyright © 2014 惠购 www.huiget.com 版权所有
 */
package cn.liuyiyou.yishop.service;

import cn.liuyiyou.yishop.entity.ValidateInfo;
import cn.liuyiyou.yishop.mapper.BaseMapper;
import cn.liuyiyou.yishop.mapper.ValidateInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ValidateInfoService extends BaseSevice {

    @Autowired
    private ValidateInfoMapper validateInfoMapper;

    public ValidateInfo findValidateInfoByCode(String code) {
        return validateInfoMapper.queryByCode(code);
    }

    public List<ValidateInfo> findValidateInfos(int userId, String target, String type) {
        return validateInfoMapper.queryValidValidateInfoByUserIdAndTargetAndType(userId, target,
            type);
    }

    public void updateStatus(ValidateInfo validateInfo) {
        validateInfo.setLastUpdateTime(new Date());
        validateInfoMapper.updateStatus(validateInfo);
    }


    @Override
    protected BaseMapper getMapper() {
        return validateInfoMapper;
    }

}
