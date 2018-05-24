package cn.liuyiyou.shop.service.impl;

import cn.liuyiyou.shop.entity.Banner;
import cn.liuyiyou.shop.mapper.BannerMapper;
import cn.liuyiyou.shop.service.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * @author: liuyiyou
 * @date: 2018/4/5
 */
@Service
public class BannerService implements IBannerService {

    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public List<Banner> getEffectBanners() {
        return bannerMapper.selectByExample(null);
    }
}
