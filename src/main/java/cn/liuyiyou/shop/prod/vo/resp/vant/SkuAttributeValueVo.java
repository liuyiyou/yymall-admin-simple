package cn.liuyiyou.shop.prod.vo.resp.vant;

import lombok.Data;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2019/12/12
 * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
 */
@Data
public class SkuAttributeValueVo {

    // skuValueId：规格值 id
    private Long id;
    // skuValueName：规格值名称
    private String name;
    // 规格类目图片，只有第一个规格类目可以定义图片
    private String imgUrl;
    // 用于预览显示的规格类目图片
    private String previewImgUrl;

}
