package cn.liuyiyou.shop.system.vo.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author: liuyiyou.cn
 * @date: 2018/12/26
 * @version: V1.0
 */
@Data
@Builder
public class TreeVo {

    @ApiModelProperty("ID")
    private Long id;

    @ApiModelProperty("父ID")
    private Long pId;

    @ApiModelProperty("树节点名称")
    private String name;

    @ApiModelProperty("是否选中")
    private boolean checked;
}
