package cn.liuyiyou.shop.prod.vo.req;

import cn.liuyiyou.shop.common.vo.PageVo;
import lombok.Data;
import lombok.experimental.Accessors;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2019/2/5
 * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
 */
@Data
@Accessors(chain = true)
public class ProdListReqVo  extends PageVo {

    private Integer cataId;
    private String orderBy;
    private Long brandId;

}
