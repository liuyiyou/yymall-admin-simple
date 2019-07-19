package cn.liuyiyou.shop.prod.controller.admin;

import cn.liuyiyou.shop.common.response.Response;
import cn.liuyiyou.shop.common.response.Result;
import cn.liuyiyou.shop.prod.service.IProdService;
import cn.liuyiyou.shop.prod.vo.ProdVo;
import cn.liuyiyou.shop.prod.vo.req.ProdListReqVo;
import cn.liuyiyou.shop.prod.vo.resp.AdminProdListRespVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: liuyiyou.cn
 * @date: 2019/7/16
 * @version: V1.0
 */
@RestController
@RequestMapping("/prod/admin")
public class AdminProdController {


    private String prefix = "prod/prod";

    @Autowired
    private IProdService prodService;


    @GetMapping("/list")
    private ModelAndView list() {
        return new ModelAndView(prefix + "/prod");
    }

    @GetMapping("/add")
    public ModelAndView add() {
        return new ModelAndView(prefix + "/add");
    }


    @GetMapping("/detail/{prodId}")
    private ModelAndView detail(@PathVariable("prodId") Long prodId) {
        ModelMap modelMap = new ModelMap();
        ProdVo prodvo = prodService.getProdById(prodId);
        modelMap.put("prodId", prodId);
        modelMap.put("prod", prodvo);
        return new ModelAndView(prefix + "/detail", modelMap);
    }


    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        return new ModelAndView(prefix + "/edit");
    }


    @PostMapping("/list")
    public Result<IPage<AdminProdListRespVo>> list(@RequestBody ProdListReqVo prodListReqVo) {
        IPage<AdminProdListRespVo> adminProdListRespVoIPage = prodService.adminProdPage(prodListReqVo);
        return Response.success(adminProdListRespVoIPage);
    }


    @GetMapping("{id}")
    public Result<ProdVo> getById(@PathVariable("id") Long id) {
        ProdVo prodvo = prodService.getProdById(id);
        return Response.success(prodvo);
    }


}
