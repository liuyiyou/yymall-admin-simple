/**
 * 
 * 惠购 - 惠购网 - www.huiget.com - 特别会购！
 * Copyright © 2014 惠购 www.huiget.com 版权所有
 */
package cn.liuyiyou.yishop.service;

import cn.liuyiyou.yishop.entity.Meta;
import cn.liuyiyou.yishop.mapper.BaseMapper;
import cn.liuyiyou.yishop.mapper.MetaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author yaofang
 * @version $Id: MetaInfoService.java, v 0.1 2014年9月25日 下午2:44:58 yaofang Exp $
 */
@Service
public class MetaService extends BaseSevice {

    @Autowired
    private MetaMapper metaInfoMapper;

    public Meta findByUri(String uri) {
        return metaInfoMapper.queryByUri(uri);
    }

    @Override
    protected BaseMapper getMapper() {
        return metaInfoMapper;
    }

}
