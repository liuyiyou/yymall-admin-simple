package cn.liuyiyou.shop.vo;

import lombok.Data;

import java.util.List;

/**
 * @author: liuyiyou.cn
 * @date: 2019/12/16
 * @version: V1.0
 */
@Data
public class TreeViewVo {

    private Long id;
    private String text;
    private Integer level;
    private List<TreeViewVo> nodes;
}
