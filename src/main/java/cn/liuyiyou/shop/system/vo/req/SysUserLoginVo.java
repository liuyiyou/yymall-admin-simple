package cn.liuyiyou.shop.system.vo.req;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author: liuyiyou.cn
 * @date: 2018/12/21
 * @version: V1.0
 */
@Data
@ApiModel("登陆")
public class SysUserLoginVo {

    @NotNull(message = "用户名不能为空")
    private String username;
    @NotNull(message = "用户密码不能为空")
    private String password;
}
