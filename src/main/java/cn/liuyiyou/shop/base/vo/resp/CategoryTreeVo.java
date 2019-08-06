package cn.liuyiyou.shop.base.vo.resp;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2019/7/30
 * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
 */
@Data
@Accessors(chain = true)
public class CategoryTreeVo {


    private Integer id;

    private String text;

    private List<CategoryTreeVo> children = Lists.newArrayList();
}
