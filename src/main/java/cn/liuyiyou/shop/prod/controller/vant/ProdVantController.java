package cn.liuyiyou.shop.prod.controller.vant;

import cn.liuyiyou.shop.common.response.Response;
import cn.liuyiyou.shop.common.response.Result;
import cn.liuyiyou.shop.prod.entity.ProdSku;
import cn.liuyiyou.shop.prod.service.IProdService;
import cn.liuyiyou.shop.prod.vo.ProdVo;
import cn.liuyiyou.shop.prod.vo.resp.vant.VantProdDetailRespVo;
import cn.liuyiyou.shop.prod.vo.resp.vant.VantProdRespVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2019/7/30
 * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
 */
@RestController
@RequestMapping("/prod/vant")
public class ProdVantController {

    @Autowired
    private IProdService prodService;


    @GetMapping("{id}")
    public Result<VantProdDetailRespVo> getById(@PathVariable("id") Long id) {
        VantProdDetailRespVo vantProdDetailRespVo = new VantProdDetailRespVo();
        VantProdRespVo vantProdRespVo = new VantProdRespVo();
        ProdVo prodvo = prodService.getProdById(id);
        BeanUtils.copyProperties(prodvo, vantProdRespVo);
        List<String> albums = prodvo.getAlbums().stream().map(thumb -> {
            thumb = "https://oss.yanglaoban.com/" + thumb;
            return thumb;
        }).collect(Collectors.toList());
        vantProdRespVo.setAlbums(albums);
        String price = prodvo.getProdSkus().stream().map(ProdSku::getPrice).map(String::valueOf).collect(Collectors.joining("~"));
        int store = prodvo.getProdSkus().stream().map(ProdSku::getStore).reduce((a, b) -> a + b).orElse(0);
        vantProdRespVo.setPrice(price);
        vantProdRespVo.setRemain(store);
        vantProdDetailRespVo.setGoods(vantProdRespVo);


        //封装SKU


        return Response.success(vantProdDetailRespVo);
    }
}
