package cn.liuyiyou.shop.manager.impl;

import cn.liuyiyou.shop.entity.Banner;
import cn.liuyiyou.shop.entity.Prod;
import cn.liuyiyou.shop.manager.IHomeManager;
import cn.liuyiyou.shop.resp.Result;
import cn.liuyiyou.shop.resp.ResultGenerator;
import cn.liuyiyou.shop.service.IBannerService;
import cn.liuyiyou.shop.service.IProdService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * @author: liuyiyou
 * @date: 2018/5/25
 */
@Service
public class HomeManager implements IHomeManager {


    @Autowired
    private IProdService prodService;
    @Autowired
    private IBannerService bannerService;

    @Override
    public Result getHomePage(int page, int pageSize) {
        JSONObject result = new JSONObject();
        result.put("banners",getBanners());
        result.put("prods",getProds(page,pageSize));
        return ResultGenerator.genSuccessResult(result);
    }

    public List<Banner> getBanners() {
        return bannerService.getEffectBanners();
    }

    public PageInfo<Prod> getProds(int page, int pageSize) {
        PageInfo<Prod> prodsPage = prodService.getProdsPage(page, pageSize);
        prodsPage.getList().forEach(prod -> prod.setAlbum(prod.getAlbum().split(",")[0]));
        return prodsPage;
    }
}
