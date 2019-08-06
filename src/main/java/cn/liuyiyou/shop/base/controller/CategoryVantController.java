package cn.liuyiyou.shop.base.controller;

import cn.liuyiyou.shop.base.entity.Category;
import cn.liuyiyou.shop.base.service.ICategoryService;
import cn.liuyiyou.shop.base.vo.resp.CategoryTreeVo;
import cn.liuyiyou.shop.common.response.Response;
import cn.liuyiyou.shop.common.response.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2019/7/30
 * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
 */
@Api(description = "类目相关接口")
@RestController
@RequestMapping("/category/vant")
public class CategoryVantController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/tree")
    public Result<List<CategoryTreeVo>> getCategoryByParentId() {
        List<CategoryTreeVo> result = new ArrayList<>();
        List<Category> firstCategories = categoryService.findListByLevel(1);
        for (Category first : firstCategories) {
            CategoryTreeVo firstVo = new CategoryTreeVo();
            firstVo.setId(first.getCataId());
            firstVo.setText(first.getCataName());
            List<CategoryTreeVo> children = new ArrayList<>();
            List<Category> secondCategories = categoryService.findListByCataParentId(first.getCataId());
            for (Category second : secondCategories) {
                CategoryTreeVo secondVo = new CategoryTreeVo();
                secondVo.setId(second.getCataId());
                secondVo.setText(second.getCataName());
                children.add(secondVo);
            }
            firstVo.setChildren(children);
            result.add(firstVo);
        }

        return Response.success(result);
    }

}
