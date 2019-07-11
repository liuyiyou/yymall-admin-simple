package cn.liuyiyou.shop.system.vo.resp.user;

import cn.liuyiyou.shop.system.vo.resp.dept.SysDeptSimpleVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author liuyiyou.cn
 * @since 2018-08-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel
public class SysUserListRespVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID")
    private Long id;

    @ApiModelProperty(value = "账号")
    private String account;

    @ApiModelProperty(value = "账号类型1：内部账号，2：供应商账号")
    private Byte accountType;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "用户邮箱")
    private String email;

    @ApiModelProperty(value = "手机号码")
    private String mobile;

    @ApiModelProperty(value = "帐号状态（0正常 1禁用 2删除）")
    private Byte status;

    @ApiModelProperty("联系人")
    private String linkman;

    @ApiModelProperty(value = "用户所属部门")
    private SysDeptSimpleVo dept;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;


}
