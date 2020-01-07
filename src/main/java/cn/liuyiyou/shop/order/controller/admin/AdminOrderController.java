package cn.liuyiyou.shop.order.controller.admin;


import cn.liuyiyou.shop.common.response.Response;
import cn.liuyiyou.shop.common.response.Result;
import cn.liuyiyou.shop.order.service.IOrderService;
import cn.liuyiyou.shop.order.vo.req.OrderAddReqVo;
import cn.liuyiyou.shop.order.vo.req.OrderListReqVo;
import cn.liuyiyou.shop.order.vo.resp.AdminOrderListRespVo;
import cn.liuyiyou.shop.order.vo.resp.OrderListRespVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/***
 *
 * 订单相关处理
 * @author: liuyiyou.cn
 * @date: 2019/2/8
 * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
 */
@RestController
@CrossOrigin
@RequestMapping("/admin/order")
@Slf4j
public class AdminOrderController {

    @Autowired
    private IOrderService orderService;


    @GetMapping("/data")
    public String  data(){
        return "[\n" +
                "        {\n" +
                "            \"orderId\":10000009735,\n" +
                "            \"status\":1,\n" +
                "            \"statusName\":\"待支付\",\n" +
                "            \"prods\":[\n" +
                "                {\n" +
                "                    \"orderId\":10000009735,\n" +
                "                    \"skuId\":11010100100001,\n" +
                "                    \"prodId\":1101010010,\n" +
                "                    \"prodName\":\"Blackmores 澳佳宝 维生素E滋润面霜 50g/支\",\n" +
                "                    \"prodNum\":1,\n" +
                "                    \"realPrice\":127,\n" +
                "                    \"album\":\"product/21/2101/210104/0010/AE4877AB8EEE8387.jpg\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"createTime\":\"2018-10-24 11:12:49\",\n" +
                "            \"consignee\":\"李大伟\",\n" +
                "            \"totalPrice\":127,\n" +
                "            \"payTypeName\":\"未支付\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\":10000009734,\n" +
                "            \"status\":1,\n" +
                "            \"statusName\":\"待支付\",\n" +
                "            \"prods\":[\n" +
                "                {\n" +
                "                    \"orderId\":10000009734,\n" +
                "                    \"skuId\":11010100050001,\n" +
                "                    \"prodId\":1101010005,\n" +
                "                    \"prodName\":\"Antipodes 安媞珀 天然有机明亮焕白洗面奶 200ml/瓶\",\n" +
                "                    \"prodNum\":1,\n" +
                "                    \"realPrice\":0,\n" +
                "                    \"album\":\"product/21/2101/210101/0005/E43DA80B0AC93990.jpg\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"createTime\":\"2018-10-24 11:12:39\",\n" +
                "            \"consignee\":\"李大伟\",\n" +
                "            \"totalPrice\":59.1,\n" +
                "            \"payTypeName\":\"未支付\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\":10000009733,\n" +
                "            \"status\":1,\n" +
                "            \"statusName\":\"待支付\",\n" +
                "            \"prods\":[\n" +
                "                {\n" +
                "                    \"orderId\":10000009733,\n" +
                "                    \"skuId\":11010100100001,\n" +
                "                    \"prodId\":1101010010,\n" +
                "                    \"prodName\":\"Blackmores 澳佳宝 维生素E滋润面霜 50g/支\",\n" +
                "                    \"prodNum\":1,\n" +
                "                    \"realPrice\":127,\n" +
                "                    \"album\":\"product/21/2101/210104/0010/AE4877AB8EEE8387.jpg\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"createTime\":\"2018-10-24 11:05:23\",\n" +
                "            \"consignee\":\"李大伟\",\n" +
                "            \"totalPrice\":127,\n" +
                "            \"payTypeName\":\"未支付\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\":10000009732,\n" +
                "            \"status\":1,\n" +
                "            \"statusName\":\"待支付\",\n" +
                "            \"prods\":[\n" +
                "                {\n" +
                "                    \"orderId\":10000009732,\n" +
                "                    \"skuId\":22101011320101,\n" +
                "                    \"prodId\":221010113201,\n" +
                "                    \"prodName\":\"测试商品\",\n" +
                "                    \"prodNum\":1,\n" +
                "                    \"realPrice\":100,\n" +
                "                    \"album\":\"product/21/2101/210101/132/0B7244650FB5421A.jpg\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"createTime\":\"2018-10-18 16:58:24\",\n" +
                "            \"consignee\":\"李大伟\",\n" +
                "            \"totalPrice\":100,\n" +
                "            \"payType\":17\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\":10000009731,\n" +
                "            \"status\":5,\n" +
                "            \"statusName\":\"订单关闭\",\n" +
                "            \"prods\":[\n" +
                "                {\n" +
                "                    \"orderId\":10000009731,\n" +
                "                    \"skuId\":22101011320101,\n" +
                "                    \"prodId\":221010113201,\n" +
                "                    \"prodName\":\"测试商品\",\n" +
                "                    \"prodNum\":1,\n" +
                "                    \"realPrice\":100,\n" +
                "                    \"album\":\"product/21/2101/210101/132/0B7244650FB5421A.jpg\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"createTime\":\"2018-10-18 16:39:40\",\n" +
                "            \"consignee\":\"李大伟\",\n" +
                "            \"totalPrice\":100,\n" +
                "            \"payType\":12\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\":10000009730,\n" +
                "            \"status\":5,\n" +
                "            \"statusName\":\"订单关闭\",\n" +
                "            \"prods\":[\n" +
                "                {\n" +
                "                    \"orderId\":10000009730,\n" +
                "                    \"skuId\":22101011320101,\n" +
                "                    \"prodId\":221010113201,\n" +
                "                    \"prodName\":\"测试商品\",\n" +
                "                    \"prodNum\":1,\n" +
                "                    \"realPrice\":100,\n" +
                "                    \"album\":\"product/21/2101/210101/132/0B7244650FB5421A.jpg\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"createTime\":\"2018-10-18 16:28:21\",\n" +
                "            \"consignee\":\"李大伟\",\n" +
                "            \"totalPrice\":100,\n" +
                "            \"payType\":17\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\":10000009729,\n" +
                "            \"status\":5,\n" +
                "            \"statusName\":\"订单关闭\",\n" +
                "            \"prods\":[\n" +
                "                {\n" +
                "                    \"orderId\":10000009729,\n" +
                "                    \"skuId\":22101011320101,\n" +
                "                    \"prodId\":221010113201,\n" +
                "                    \"prodName\":\"测试商品\",\n" +
                "                    \"prodNum\":1,\n" +
                "                    \"realPrice\":100,\n" +
                "                    \"album\":\"product/21/2101/210101/132/0B7244650FB5421A.jpg\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"createTime\":\"2018-10-18 16:19:41\",\n" +
                "            \"consignee\":\"李大伟\",\n" +
                "            \"totalPrice\":100,\n" +
                "            \"payType\":17\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\":10000009728,\n" +
                "            \"status\":3,\n" +
                "            \"statusName\":\"待确认收货\",\n" +
                "            \"prods\":[\n" +
                "                {\n" +
                "                    \"orderId\":10000009728,\n" +
                "                    \"skuId\":15010200060001,\n" +
                "                    \"prodId\":1501020006,\n" +
                "                    \"prodName\":\"Blackmores 澳佳宝 无腥味深海鱼油胶囊 400粒/瓶\",\n" +
                "                    \"prodNum\":4,\n" +
                "                    \"realPrice\":624,\n" +
                "                    \"album\":\"product/15/1501/150102/0006/41760A34A36F9FF2.jpg\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"createTime\":\"2018-10-13 11:06:00\",\n" +
                "            \"consignee\":\"李大伟\",\n" +
                "            \"totalPrice\":624,\n" +
                "            \"payType\":9,\n" +
                "            \"payTypeName\":\"余额支付\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\":10000009727,\n" +
                "            \"status\":4,\n" +
                "            \"statusName\":\"交易完成\",\n" +
                "            \"prods\":[\n" +
                "                {\n" +
                "                    \"orderId\":10000009727,\n" +
                "                    \"skuId\":15010200060001,\n" +
                "                    \"prodId\":1501020006,\n" +
                "                    \"prodName\":\"Blackmores 澳佳宝 无腥味深海鱼油胶囊 400粒/瓶\",\n" +
                "                    \"prodNum\":3,\n" +
                "                    \"realPrice\":468,\n" +
                "                    \"album\":\"product/15/1501/150102/0006/41760A34A36F9FF2.jpg\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"createTime\":\"2018-10-12 21:06:39\",\n" +
                "            \"consignee\":\"李大伟\",\n" +
                "            \"totalPrice\":468,\n" +
                "            \"payType\":9,\n" +
                "            \"payTypeName\":\"余额支付\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\":10000009726,\n" +
                "            \"status\":3,\n" +
                "            \"statusName\":\"待确认收货\",\n" +
                "            \"prods\":[\n" +
                "                {\n" +
                "                    \"orderId\":10000009726,\n" +
                "                    \"skuId\":15010200060001,\n" +
                "                    \"prodId\":1501020006,\n" +
                "                    \"prodName\":\"Blackmores 澳佳宝 无腥味深海鱼油胶囊 400粒/瓶\",\n" +
                "                    \"prodNum\":2,\n" +
                "                    \"realPrice\":312,\n" +
                "                    \"album\":\"product/15/1501/150102/0006/41760A34A36F9FF2.jpg\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"createTime\":\"2018-10-12 17:57:20\",\n" +
                "            \"consignee\":\"李大伟\",\n" +
                "            \"totalPrice\":312,\n" +
                "            \"payType\":9,\n" +
                "            \"payTypeName\":\"余额支付\"\n" +
                "        }\n" +
                "    ]";
    }


    @ApiOperation("订单列表-前端展示")
    @PostMapping("/list")
    public Result adminList(@RequestBody @NotNull OrderListReqVo orderListReqVo) {
        Page<AdminOrderListRespVo> result = orderService.getAdminOrderList(orderListReqVo);
        return Response.success().setData(result);
    }


    @ApiOperation("订单详情")
    @GetMapping("/{id}")
    public Result adminDetail(@PathVariable("id") Long orderId) {
        return Response.success(orderService.getAdminOrderInfo(orderId));
    }


    @ApiOperation("订单提交")
    @PostMapping("/add")
    public Result<Long> add(@RequestBody OrderAddReqVo orderAddReqVo) {
        return Response.success(orderService.createOrder(orderAddReqVo));
    }


    @ApiOperation("取消")
    @GetMapping("/cancel/{id}")
    public Result cancel(@PathVariable("id") Long orderId) {
        return Response.success(orderService.cancelOrder(orderId));
    }

    @ApiOperation("订单支付")
    @GetMapping("/pay/{id}")
    public Result pay(@PathVariable("id") Long orderId) {
        return Response.success(orderService.payOrder(orderId));
    }

    @ApiOperation("确认收货")
    @GetMapping("/confirm/{id}")
    public Result confirm(@PathVariable("id") Long orderId) {
        return Response.success(orderService.confrimOrder(orderId));
    }
}

