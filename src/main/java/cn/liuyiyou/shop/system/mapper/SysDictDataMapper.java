package cn.liuyiyou.shop.system.mapper;

import cn.liuyiyou.shop.system.entity.SysDictData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 字典数据表 Mapper 接口
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2018-08-27
 */
@Repository
public interface SysDictDataMapper extends BaseMapper<SysDictData> {

    List<SysDictData> selectDictDataByType(String dictType);
}
