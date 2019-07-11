package cn.liuyiyou.shop.system.vo.resp.log;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 操作日志记录
 * </p>
 *
 * @author liuyiyou
 * @since 2019-02-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysOperLogVo implements Serializable {

    @ApiModelProperty("日志主键")
    private Long id;

    @ApiModelProperty("所属模块")
    private String title;


    @ApiModelProperty("操作内容")
    private String action;


    @ApiModelProperty("模块标题")
    private String method;


    @ApiModelProperty("登录账号ID")
    private Long operId;

    @ApiModelProperty("登录账号")
    private String operName;


    @ApiModelProperty("请求URL")
    private String operUrl;


    @ApiModelProperty("IP")
    private String operIp;


    @ApiModelProperty("操作地点")
    private String operLocation;

    /**
     * 请求参数
     */
    @ApiModelProperty("请求参数")
    private String operParam;

    @ApiModelProperty("操作状态 0正常 1异常")
    private Integer status;


    @ApiModelProperty("错误消息")
    private String errorMsg;


    @ApiModelProperty("操作时间")
    private LocalDateTime operTime;

}
