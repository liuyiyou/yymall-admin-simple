//package cn.liuyiyou.shop.user.service;
//
//import cn.liuyiyou.shop.AbstractTest;
//import cn.liuyiyou.shop.user.entity.UserDelivery;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
///***
// *
// * @author: liuyiyou.cn
// * @date: 2019/7/29
// * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
// */
//public class UserDeliveryServiceTest extends AbstractTest {
//
//
//    @Autowired
//    private UserDeliveryService userDeliveryService;
//
//    @Test
//    public void transAddressDetailToAddressBatch() {
//        List<UserDelivery> userDeliveries = userDeliveryService.list();
//        List<UserDelivery> collect = userDeliveries.parallelStream().map(userDelivery -> {
//            String addressDetail = userDelivery.getAddressDetail();
//            JSONObject jsonObject = JSON.parseObject(addressDetail);
//            String prov = jsonObject.getString("prov");
//            String city = jsonObject.getString("city");
//            String county = jsonObject.getString("county");
//            String address = jsonObject.getString("addr");
//            userDelivery.setAddress(prov + city + county + address);
//            return userDelivery;
//        }).collect(Collectors.toList());
//        userDeliveryService.updateBatchById(collect);
//
//    }
//
//}
