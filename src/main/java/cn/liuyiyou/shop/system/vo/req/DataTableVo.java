package cn.liuyiyou.shop.system.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2019/1/15
 * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
 */
@Data
@ApiModel()
public class DataTableVo {

    @ApiModelProperty(value = "页码", required = true)
    @NotNull(message = "页码不能为空")
    private Integer pageNum;

    @NotNull(message = "每页条数不能为空")
    @ApiModelProperty(value = "每页条数", required = true)
    private Integer pageSize;

    @ApiModelProperty("查询字段")
    private String searchValue;

    @ApiModelProperty("排序字段")
    private String orderByColum;

    @ApiModelProperty("是否降序")
    private Boolean desc = false;

}
