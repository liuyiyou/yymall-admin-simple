package cn.liuyiyou.shop.prod.vo.resp.vant;

import lombok.Data;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2019/12/12
 * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
 */
@Data
public class SkuListVo {

    private Long id;//: 2259, // skuId，下单时后端需要
    private Float price;//: 100, // 价格（单位分）
    private Integer stockNum; //:110 // 当前 sku 组合对应的库存
}
