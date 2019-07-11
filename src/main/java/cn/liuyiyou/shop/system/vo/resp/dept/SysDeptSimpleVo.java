package cn.liuyiyou.shop.system.vo.resp.dept;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: liuyiyou.cn
 * @date: 2018/12/29
 * @version: V1.0
 */
@Data
public class SysDeptSimpleVo {

    @ApiModelProperty("部门id")
    private Long id;

    @ApiModelProperty("部门名称")
    private String deptName;

    @ApiModelProperty("父部门id")
    private Long parentId;

    @ApiModelProperty("部门状态")
    private Byte status;
}
