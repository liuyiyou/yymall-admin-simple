package cn.liuyiyou.shop.system.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @author: liuyiyou.cn
 * @date: 2018/12/26
 * @version: V1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
@ApiModel
public class SysRoleAddVo {

    @ApiModelProperty(value = "角色ID")
    private Long id;

    @ApiModelProperty(value = "角色名称")
    @NotNull(message = "角色名称必填")
    private String roleName;

    @ApiModelProperty(value = "角色英文名称")
    private String roleKey;

    @ApiModelProperty(value = "角色显示顺序")
    @Max(value = 100,message = "角色显示顺序小于100")
    private int roleSort;

    @ApiModelProperty(value = "角色状态:0正常,1禁用")
    private Byte status;

    @ApiModelProperty(value = "角色说明")
    private String remark;

    @ApiModelProperty(value = "菜单组")
    private  Long[]  menuIds;
}
