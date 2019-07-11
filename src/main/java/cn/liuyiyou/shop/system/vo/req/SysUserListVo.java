package cn.liuyiyou.shop.system.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author: liuyiyou.cn
 * @date: 2018/12/20
 * @version: V1.0
 */
@Data
@ApiModel
public class SysUserListVo extends DataTableVo {

    @ApiModelProperty("部门Id")
    private Long deptId;
    @ApiModelProperty("部门父ID")
    private Long parentId;
    @ApiModelProperty("用户状态")
    private Byte status;
    @ApiModelProperty("账号类型1：内部账号，2：供应商账号")
    private Byte accountType;
}
