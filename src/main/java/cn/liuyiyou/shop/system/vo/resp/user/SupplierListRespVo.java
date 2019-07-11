package cn.liuyiyou.shop.system.vo.resp.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author qww
 * @date 19-2-19
 */
@Data
@Accessors(chain = true)
public class SupplierListRespVo {
    @ApiModelProperty(value = "供应商标识,true-供应商,false-不是供应商")
    private boolean self;

    @ApiModelProperty(value = "供应商列表")
    private List<SupplierSimpleRespVo> supplierList;
}
