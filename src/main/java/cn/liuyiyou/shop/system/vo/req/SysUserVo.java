package cn.liuyiyou.shop.system.vo.req;

import cn.liuyiyou.shop.config.validator.ValidatorGroupEdit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 新增用户请求对象
 *
 * @author: liuyiyou.cn
 * @date: 2018/12/26
 * @version: V1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
@ApiModel
public class SysUserVo implements Serializable {

    @ApiModelProperty(value = "ID")
    @NotNull(groups = ValidatorGroupEdit.class, message = "用户Id不能为空")
    private Long id;

    @ApiModelProperty(value = "账号", required = true)
    @NotNull(message = "账号不能为空")
    private String account;

    @ApiModelProperty(value = "账号类型", required = true)
    @NotNull(message = "账号类型不能为空")
    private Byte accountType;

    @ApiModelProperty(value = "用户昵称")
    @Length(max = 20, message = "用户昵称长度不能大于20")
    private String nickName;

    @ApiModelProperty(value = "手机号码", required = true)
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手机号码格式错误")
    @NotBlank(message = "手机号码不能为空")
    private String mobile;


    @ApiModelProperty(value = "用户性别:0男,1女")
    private String sex;


    @ApiModelProperty(value = "头像路径")
    private String avatar;

    @ApiModelProperty(value = "密码", required = true)
    private String password;


    @ApiModelProperty(value = "帐号状态（0正常 1禁用 2删除）")
    private Byte status;


    @ApiModelProperty(value = "部门ID", required = true)
    private Long deptId;

    @ApiModelProperty(value = "角色ID数组")
    private Long[] roleIds;


    @ApiModelProperty(value = "供应商邮箱")
    @Length(max = 20, message = "供应商邮箱长度不能大于100")
    @Email(message = "email格式不正确")
    private String email;

    @ApiModelProperty(value = "联系地址")
    private String address;

}
