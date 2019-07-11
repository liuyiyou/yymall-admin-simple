package cn.liuyiyou.shop.system.vo.resp.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2019/1/7
 * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel
public class SysSupplierListRespVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("供应商ID与用户ID一致")
    private Long id;

    @ApiModelProperty("供应商名称")
    private String supplierName;

    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("联系人")
    private String linkman;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("联系地址")
    private String address;

    @ApiModelProperty("ERP编码")
    private String erpCode;

}
