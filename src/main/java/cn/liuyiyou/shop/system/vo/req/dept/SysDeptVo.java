package cn.liuyiyou.shop.system.vo.req.dept;

import cn.liuyiyou.shop.config.validator.ValidatorGroupEdit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 部门表
 */
@Data
@Accessors(chain = true)
@ApiModel
public class SysDeptVo implements Serializable {

    @ApiModelProperty("部门ID")
    @NotNull(groups = ValidatorGroupEdit.class, message = "部门Id不能为空")
    private Long id;

    @ApiModelProperty("父部门id")
    @NotNull(message = "父部门Id不能为空")
    private Long parentId;

    @ApiModelProperty("部门名称")
    @NotNull(message = "部门名称不能为空")
    @Length(max = 30, message = "部门名称不能大于30")
    private String deptName;

    @ApiModelProperty("显示顺序")
    private Integer orderNum;

    @ApiModelProperty("部门负责人")
    @Length(max = 20, message = "负责人名称不能大于20")
    private String leader;

    @ApiModelProperty("联系电话")
    @Length(max = 11, message = "联系人电话不能超过11位")
    private String mobile;

    @ApiModelProperty("邮箱")
    @Email(message = "Email格式不正确")
    @Length(max = 50, message = "Email长度不能超过50")
    private String email;

    @ApiModelProperty("部门状态:0正常,1停用")
    //用Byte默认会用String来传
    private Byte status;
}
