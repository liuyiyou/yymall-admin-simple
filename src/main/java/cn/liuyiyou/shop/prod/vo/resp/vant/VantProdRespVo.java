package cn.liuyiyou.shop.prod.vo.resp.vant;

import lombok.Data;

import java.util.List;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2019/7/30
 * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
 */
@Data
public class VantProdRespVo {
    private List<String> albums;
    private Long prodId;
    private String prodName;
    private Integer brandId;
    private String brandName;
    private Integer cataId;
    private String country;
    private String price;
    private Integer remain;
}
