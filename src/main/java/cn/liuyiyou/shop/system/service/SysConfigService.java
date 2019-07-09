package cn.liuyiyou.shop.system.service;

import cn.liuyiyou.shop.system.entity.SysConfig;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 参数配置表 服务类
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2018-08-27
 */
public interface SysConfigService extends IService<SysConfig> {

    /**
     * 根据键名查询参数配置信息
     *
     * @param configKey 参数键名
     * @return 参数键值
     */
    String selectConfigByKey(String configKey);
}
