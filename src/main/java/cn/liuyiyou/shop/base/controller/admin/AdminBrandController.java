package cn.liuyiyou.shop.base.controller.admin;

import cn.liuyiyou.shop.base.entity.Brand;
import cn.liuyiyou.shop.base.service.IBrandService;
import cn.liuyiyou.shop.common.response.Response;
import cn.liuyiyou.shop.common.response.Result;
import cn.liuyiyou.shop.common.vo.PageVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;
import java.util.List;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2019/7/12
 * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
 */
@RequestMapping("/base/admin/brand")
@RestController
public class AdminBrandController {

    private String prefix = "base/brand";


    @Autowired
    private IBrandService brandService;

    @GetMapping("/list")
    public ModelAndView list() {
        return new ModelAndView(prefix + "/brand");
    }

    @GetMapping("/all")
    public Result<List<Brand>> all() {
        return Response.success(brandService.list());
    }

    @PostMapping("/list")
    public Result<IPage<Brand>> list(@RequestBody @NotNull PageVo pageVo) {
        IPage<Brand> brandByPage = brandService.getBrandByPage(pageVo);
        return Response.success(brandByPage);
    }
}
