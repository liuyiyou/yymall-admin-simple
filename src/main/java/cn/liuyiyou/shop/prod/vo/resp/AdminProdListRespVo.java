package cn.liuyiyou.shop.prod.vo.resp;

import cn.liuyiyou.shop.prod.entity.Prod;
import cn.liuyiyou.shop.prod.entity.ProdSku;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2019/2/5
 * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
 */
@Data
@Accessors(chain = true)
public class AdminProdListRespVo extends Prod {
    private List<ProdSku> skus;


}
