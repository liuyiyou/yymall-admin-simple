package cn.liuyiyou.shop.system.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author: liuyiyou.cn
 * @date: 2018/12/20
 * @version: V1.0
 */
@Data
@ApiModel
public class SysLogListVo extends DataTableVo {


    @ApiModelProperty("操作内容")
    private String action;

    @ApiModelProperty("操作人")
    private String operName;

    @ApiModelProperty("操作状态 0正常 1异常")
    private Integer status;

    @ApiModelProperty("操作开始时间")
    private String startTime;

    @ApiModelProperty("操作结束时间")
    private String endTime;


}
