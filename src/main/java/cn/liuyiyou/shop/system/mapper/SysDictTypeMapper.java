package cn.liuyiyou.shop.system.mapper;

import cn.liuyiyou.shop.system.entity.SysDictType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 字典类型表 Mapper 接口
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2018-09-03
 */
@Repository
public interface SysDictTypeMapper extends BaseMapper<SysDictType> {

    SysDictType checkDictTypeUnique(String dictType);
}
