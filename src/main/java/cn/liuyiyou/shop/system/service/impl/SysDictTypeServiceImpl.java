package cn.liuyiyou.shop.system.service.impl;

import cn.liuyiyou.shop.system.constans.UserConstants;
import cn.liuyiyou.shop.system.entity.SysDictType;
import cn.liuyiyou.shop.system.mapper.SysDictTypeMapper;
import cn.liuyiyou.shop.system.service.ISysDictTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 * 字典类型表 服务实现类
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2018-09-03
 */
@Service
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeMapper, SysDictType> implements ISysDictTypeService {

    @Autowired
    private SysDictTypeMapper sysDictTypeMapper;

    @Override
    public String checkDictTypeUnique(SysDictType dictType) {
        if (dictType.getDictId() == null) {
            dictType.setDictId(-1);
        }
        Integer dictId = dictType.getDictId();
        SysDictType dbDictType = sysDictTypeMapper.checkDictTypeUnique(dictType.getDictType());
        if (Objects.nonNull(dbDictType) && dbDictType.getDictId().equals(dictId)) {
            return UserConstants.DICT_TYPE_NOT_UNIQUE;
        }
        return UserConstants.DICT_TYPE_UNIQUE;
    }
}
