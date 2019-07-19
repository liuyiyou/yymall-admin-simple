package cn.liuyiyou.shop.base.controller.admin;

import cn.liuyiyou.shop.base.entity.Category;
import cn.liuyiyou.shop.base.service.ICategoryService;
import cn.liuyiyou.shop.base.vo.CascaderVo;
import cn.liuyiyou.shop.common.response.Response;
import cn.liuyiyou.shop.common.response.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author: liuyiyou.cn
 * @date: 2019/7/16
 * @version: V1.0
 */
@RequestMapping("/base/admin/category")
@RestController
public class AdminCategoryPageController {


    @Autowired
    private ICategoryService categoryService;

    @ApiOperation(value = "从一级类目往下获取")
    @GetMapping("/list")
    public ModelAndView list() {
        return new ModelAndView("base/category/category");
    }


    @GetMapping("/add/{parentId}")
    public ModelAndView add(@PathVariable("parentId") Long parentId, Model model) {
        Category category;
        if (0L != parentId) {
            category = categoryService.getById(parentId);
        } else {
            category = new Category();
            category.setCataId(0);
            category.setCataName("主目录");
        }
        model.addAttribute("category", category);
        return new ModelAndView("base/category/add");
    }

}
