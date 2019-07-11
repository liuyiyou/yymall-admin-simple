package cn.liuyiyou.shop.system.vo.resp.dept;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2019/1/4
 * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel("部门列表")
public class SysDeptListRespVo {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty("部门ID")
    private Long id;

    @ApiModelProperty("父部门id")
    private Long parentId;

    @ApiModelProperty("部门名称")
    private String deptName;


    @ApiModelProperty("父部门名称")
    private String parentName;


    @ApiModelProperty("显示顺序")
    private Integer orderNum;


    @ApiModelProperty("负责人")
    private String leader;

    @ApiModelProperty("联系电话")
    private String mobile;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("部门状态:0正常,1停用")
    private Byte status;

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新人")
    private String updateBy;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;


}
