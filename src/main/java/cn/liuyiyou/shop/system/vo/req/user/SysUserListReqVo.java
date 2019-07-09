package cn.liuyiyou.shop.system.vo.req.user;

import cn.liuyiyou.shop.system.vo.req.DataTableVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2019/1/15
 * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
 */
@Data
@Accessors(chain = true)
@ApiModel
public class SysUserListReqVo extends DataTableVo {

    @ApiModelProperty("部门Id")
    private Integer deptId;
    @ApiModelProperty("部门父ID")
    private Integer parentId;
    @ApiModelProperty("用户状态")
    private Byte status;
}
