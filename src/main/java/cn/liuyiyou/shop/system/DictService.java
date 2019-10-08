package cn.liuyiyou.shop.system;

import cn.liuyiyou.shop.system.entity.SysDictData;
import cn.liuyiyou.shop.system.service.ISysDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: liuyiyou@liuyiyou.cn
 * @date: 2018/8/27
 * @version: V1.0
 * @Copyright: 2018 liuyiyou.cn Inc. All rights reserved.
 */
@Component
public class DictService {
    @Autowired
    private ISysDictDataService dictDataService;

    /**
     * 根据字典类型查询字典数据信息
     *
     * @param dictType 字典类型
     * @return 参数键值
     */
    public List<SysDictData> selectDictData(String dictType) {
        return dictDataService.selectDictDataByType(dictType);
    }
}

