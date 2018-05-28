package cn.liuyiyou.shop.controller;

import cn.liuyiyou.shop.resp.Result;
import cn.liuyiyou.shop.resp.ResultGenerator;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * 购物车管理
 * @author: liuyiyou
 * @date: 2018/5/28
 */
@RestController
public class CartController {


    @PostMapping("addCart")
    public Result addCart() {
        JSONObject result = new JSONObject();
        result.put("data",2);
        return ResultGenerator.genSuccessResult(result);
    }
}
