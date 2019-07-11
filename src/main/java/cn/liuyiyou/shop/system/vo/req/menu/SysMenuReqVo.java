package cn.liuyiyou.shop.system.vo.req.menu;

import cn.liuyiyou.shop.config.validator.ValidatorGroupEdit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel("新增修改菜单VO")
public class SysMenuReqVo {
    @ApiModelProperty("菜单Id,新增时不需要")
    @NotNull(groups = ValidatorGroupEdit.class, message = "菜单ID不能为空")
    private Long id;

    @ApiModelProperty(value = "菜单名称", required = true)
    @NotNull(message = "菜单名称不能为空")
    private String menuName;

    @ApiModelProperty(value = "父菜单ID", required = true)
    private Long parentId;

    @ApiModelProperty(value = "显示顺序", required = true)
    private Integer orderNum;

    @ApiModelProperty(value = "请求组件", required = true)
    private String component;

    @ApiModelProperty(value = "请求地址", required = true)
    private String path;

    @ApiModelProperty(value = "类型:M目录,C菜单,F按钮,P:项目", required = true)
    @NotNull(message = "菜单类型不能为空")
    @Length(max = 1, message = "菜单长度不能大于1")
    private String menuType;

    @ApiModelProperty(value = "是否可见")
    private Boolean visible;

    @ApiModelProperty(value = "是否缓存")
    private Boolean cachable;

    @NotNull(message = "权限标识不能为空")
    @ApiModelProperty(value = "权限标识", required = true)
    private String perms;

    @ApiModelProperty(value = "菜单图标")
    private String icon;

    @ApiModelProperty(value = "备注")
    private String remark;
}
