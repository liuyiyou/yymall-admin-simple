package cn.liuyiyou.shop.prod.vo;

import cn.liuyiyou.shop.prod.entity.Prod;
import cn.liuyiyou.shop.prod.entity.ProdSku;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 商品详情
 *
 * @author: liuyiyou.cn
 * @date: 2019/1/24
 * @version: V1.0
 */
@Data
@Accessors(chain = true)
public class ProdDetailVo extends Prod implements Serializable {

    private List<ProdSku> skus;
}
