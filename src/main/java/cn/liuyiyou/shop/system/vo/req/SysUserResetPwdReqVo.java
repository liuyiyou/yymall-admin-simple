package cn.liuyiyou.shop.system.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
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
@ApiModel
public class SysUserResetPwdReqVo implements Serializable {

    @ApiModelProperty(value = "用户Id")
    @NotNull(message = "用户Id不能为空")
    private Long id;

    @ApiModelProperty(value = "新密码")
    @NotNull(message = "新密码不能为空")
    private String password;


    @ApiModelProperty(value = "确认密码")
    @NotNull(message = "确认新密码不能为空")
    private String confirmPassword;
}
