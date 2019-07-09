package cn.liuyiyou.shop.system.service.impl;

import cn.liuyiyou.shop.system.entity.SysConfig;
import cn.liuyiyou.shop.system.mapper.SysConfigMapper;
import cn.liuyiyou.shop.system.service.SysConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 参数配置表 服务实现类
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2018-08-27
 */
@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements SysConfigService {

    @Autowired
    private SysConfigMapper sysConfigMapper;

    @Override
    public String selectConfigByKey(String configKey) {
        SysConfig config = sysConfigMapper.selectConfigByKey(configKey);
        return config.getConfigValue();
    }
}
