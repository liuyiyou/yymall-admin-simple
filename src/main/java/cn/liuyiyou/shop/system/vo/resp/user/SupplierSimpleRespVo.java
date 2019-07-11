package cn.liuyiyou.shop.system.vo.resp.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author qww
 * @date 19-1-8
 */
@Data
@Accessors(chain = true)
public class SupplierSimpleRespVo {
    @ApiModelProperty(value = "供应商ID")
    private Long id;

    @ApiModelProperty(value = "供应商名字")
    private String supplierName;
}
