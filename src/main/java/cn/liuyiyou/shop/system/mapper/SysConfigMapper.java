package cn.liuyiyou.shop.system.mapper;

import cn.liuyiyou.shop.system.entity.SysConfig;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 参数配置表 Mapper 接口
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2018-08-27
 */
@Repository
public interface SysConfigMapper extends BaseMapper<SysConfig> {

    SysConfig selectConfigByKey(String configKey);
}
