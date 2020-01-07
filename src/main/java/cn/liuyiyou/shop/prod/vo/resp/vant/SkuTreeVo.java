package cn.liuyiyou.shop.prod.vo.resp.vant;

import lombok.Data;

import java.util.List;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2019/12/12
 * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
 */
@Data
public class SkuTreeVo {

    private String k;
    private List<SkuAttributeValueVo> v;

    // skuKeyStr：sku 组合列表（下方 list）中当前类目对应的 key 值，value 值会是从属于当前类目的一个规格值 id
    private String k_s;
}
