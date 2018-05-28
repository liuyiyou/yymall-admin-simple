package cn.liuyiyou.shop.controller;

import cn.liuyiyou.shop.entity.Prod;
import cn.liuyiyou.shop.manager.IHomeManager;
import cn.liuyiyou.shop.req.ReqBody;
import cn.liuyiyou.shop.resp.Result;
import cn.liuyiyou.shop.resp.ResultGenerator;
import cn.liuyiyou.shop.service.IBannerService;
import cn.liuyiyou.shop.service.IProdService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/***
 *
 * 首页
 * @author: liuyiyou
 * @date: 2018/4/4
 */
@RestController
@Slf4j
public class HomeController {


    @Autowired
    private IHomeManager homeManager;

    @Autowired
    private IProdService prodService;
    @Autowired
    private IBannerService bannerService;


    @ApiOperation(value = "首页", notes = "包含品牌、商品")
    @PostMapping("/index")
    public Result home(@RequestBody ReqBody reqBody) {
        log.info(reqBody.toString());
        Result home = homeManager.getHomePage(reqBody.page, reqBody.pageSize);
        return home;
    }



    @ApiOperation(value = "首页Banner")
    @GetMapping("/banner")
    public Result getHomePage() {
        return ResultGenerator.genSuccessResult(bannerService.getEffectBanners());
    }


    @ApiOperation(value = "特价商品")
    @GetMapping("/special")
    public Result getProds() {
        PageInfo<Prod> prodsPage = prodService.getProdsPage(1, 7);
        prodsPage.getList().forEach(prod -> prod.setAlbum(prod.getAlbum()));
        return ResultGenerator.genSuccessResult(prodsPage);
    }
}
