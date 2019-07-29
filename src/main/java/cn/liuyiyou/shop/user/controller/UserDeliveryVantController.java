package cn.liuyiyou.shop.user.controller;

import cn.liuyiyou.shop.common.response.Response;
import cn.liuyiyou.shop.common.response.Result;
import cn.liuyiyou.shop.user.entity.UserDelivery;
import cn.liuyiyou.shop.user.service.UserDeliveryService;
import cn.liuyiyou.shop.user.vo.resp.UserDeliveryListRespVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static cn.liuyiyou.shop.common.web.BaseController.getUid;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2019/7/30
 * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
 */
@Api(description = "用户收获地址管理")
@RestController
@RequestMapping("/user/delivery/vant")
public class UserDeliveryVantController {

    @Autowired
    private UserDeliveryService userDeliveryService;

    @ApiOperation(value = "获取收货地址列表")
    @PostMapping("/list")
    public Result<UserDeliveryListRespVo> list(HttpServletRequest request) {
        Integer uid = getUid(request);
        List<UserDelivery> userDeliveries = userDeliveryService.list(new QueryWrapper<UserDelivery>().eq("uid", uid));
        final Long[] chosenAddressId = {1L};
        userDeliveries.forEach(userDelivery -> {
            if (userDelivery.getIsDefault()) {
                chosenAddressId[0] = userDelivery.getId();
            }
            userDelivery.setAddress(userDelivery.getProvince() + userDelivery.getCity() + userDelivery.getCounty() + userDelivery.getAddressDetail());
        });
        UserDeliveryListRespVo vo = new UserDeliveryListRespVo();
        vo.setList(userDeliveries);
        vo.setChosenAddressId(String.valueOf(chosenAddressId[0]));
        return Response.success(vo);
    }

}
