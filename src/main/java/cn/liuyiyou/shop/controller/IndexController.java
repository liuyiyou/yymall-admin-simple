package cn.liuyiyou.shop.controller;

import cn.liuyiyou.shop.entity.Prod;
import cn.liuyiyou.shop.req.ReqBody;
import cn.liuyiyou.shop.resp.Result;
import cn.liuyiyou.shop.service.IBannerService;
import cn.liuyiyou.shop.service.IProdService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static cn.liuyiyou.shop.resp.ResultGenerator.genSuccessResult;

/***
 *
 * 首页
 * @author: liuyiyou
 * @date: 2018/4/4
 */
@RestController
@RequestMapping("/")
@Slf4j
public class IndexController {

    @Autowired
    private IProdService prodService;

    @Autowired
    private IBannerService bannerService;

    /**
     * 商品列表
     * @param reqBody
     * @return
     */
    @PostMapping("prods")
    public Result getProds(@RequestBody ReqBody reqBody) {
        PageInfo<Prod> prodsPage = prodService.getProdsPage(reqBody.page, reqBody.pageSize);
        prodsPage.getList().forEach(prod -> prod.setAlbum(prod.getAlbum().split(",")[0]));
        return genSuccessResult(prodsPage);
    }


    @PostMapping("banners")
    public Result getBanners() {
        return genSuccessResult(bannerService.getEffectBanners());
    }
}
