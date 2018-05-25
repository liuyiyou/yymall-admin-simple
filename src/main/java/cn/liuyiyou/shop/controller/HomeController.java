package cn.liuyiyou.shop.controller;

import cn.liuyiyou.shop.manager.IHomeManager;
import cn.liuyiyou.shop.req.ReqBody;
import cn.liuyiyou.shop.resp.Result;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @ApiOperation(value = "首页", notes = "包含品牌、商品")
    @PostMapping("/")
    public Result home(@RequestBody ReqBody reqBody) {
        Result home = homeManager.getHomePage(reqBody.page, reqBody.pageSize);
        return home;
    }


}
