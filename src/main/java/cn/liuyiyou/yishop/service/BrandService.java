/**
 * 
 * 惠购 - 惠购网 - www.huiget.com - 特别会购！
 * Copyright © 2014 惠购 www.huiget.com 版权所有
 */
package cn.liuyiyou.yishop.service;

import cn.liuyiyou.yishop.mapper.BaseMapper;
import cn.liuyiyou.yishop.mapper.BrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author yaofang
 * @version $Id: BrandInfoService.java, v 0.1 2014年9月25日 下午6:05:15 yaofang Exp $
 */
@Service
public class BrandService extends BaseSevice {

    @Autowired
    private BrandMapper brandInfoMapper;

    public void setLogo(int id, String logo) {
        brandInfoMapper.updateLogo(id, logo);
    }


    @Override
    protected BaseMapper getMapper() {
        return brandInfoMapper;
    }

}
