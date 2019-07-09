package cn.liuyiyou.shop.system.service.impl;

import cn.liuyiyou.shop.system.entity.SysDictData;
import cn.liuyiyou.shop.system.mapper.SysDictDataMapper;
import cn.liuyiyou.shop.system.service.ISysDictDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 字典数据表 服务实现类
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2018-08-27
 */
@Service
public class SysDictDataServiceImpl extends ServiceImpl<SysDictDataMapper, SysDictData> implements ISysDictDataService {

    @Autowired
    private SysDictDataMapper sysDictDataMapper;
    @Override
    public List<SysDictData> selectDictDataByType(String dictType) {
        return sysDictDataMapper.selectDictDataByType(dictType);
    }
}
