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
public class VantProdSkuRespVo {

    List<SkuTreeVo> tree;
    List<String> list;
}
