package cn.liuyiyou.shop.base.controller.admin;

import cn.liuyiyou.shop.base.entity.Category;
import cn.liuyiyou.shop.base.service.ICategoryService;
import cn.liuyiyou.shop.base.vo.CascaderVo;
import cn.liuyiyou.shop.common.response.Response;
import cn.liuyiyou.shop.common.response.Result;
import cn.liuyiyou.shop.vo.TreeViewVo;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: liuyiyou.cn
 * @date: 2019/7/16
 * @version: V1.0
 */
@RequestMapping("/base/admin/category")
@RestController
public class AdminCategoryController {


    @Autowired
    private ICategoryService categoryService;

    @ApiOperation(value = "获取一级类目")
    @GetMapping("/list2")
    public List<Category> firtCatagoryList() {
        return categoryService.list();
    }

    @GetMapping("/parent/{pid}")
    public Result<List<TreeViewVo>> getCategoryByPid(@PathVariable("pid") Integer pid) {
        List<Category> categories = categoryService.findListByCataParentId(pid);
        List<TreeViewVo> nodes = Lists.newArrayList();
        categories.forEach(category -> {
            TreeViewVo treeViewVo = new TreeViewVo();
            treeViewVo.setText(category.getCataName());
            treeViewVo.setId(Long.valueOf(category.getCataId()));
            treeViewVo.setNodes(Lists.newArrayList());
            treeViewVo.setLevel(category.getCataType());
            nodes.add(treeViewVo);
        });
        return Response.success(nodes);
    }

    @ApiOperation(value = "从一级类目往下获取")
    @GetMapping("/tree")
    public Result<List<CascaderVo>> getCategoryAdminTree() {
        return Response.success(categoryService.getCascaderVo());
    }
}
