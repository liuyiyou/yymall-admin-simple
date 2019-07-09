package cn.liuyiyou.shop.system.service;

import cn.liuyiyou.shop.system.entity.SysDictType;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 字典类型表 服务类
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2018-09-03
 */
public interface ISysDictTypeService extends IService<SysDictType> {

    String checkDictTypeUnique(SysDictType dictType);
}
