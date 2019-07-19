package cn.liuyiyou.shop.order.controller.admin;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 方便前后端分离，该页面只有页面跳转
 *
 * @author: liuyiyou.cn
 * @date: 2019/7/12
 * @version: V1.0
 */
@RestController
@RequestMapping("/admin/order")
public class AdminOrderPageController {

    private String prefix = "oms/order";

    /**
     * 订单列表页面
     *
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list() {
        return new ModelAndView(prefix + "/order");
    }

    /**
     * 订单详情页面
     *
     * @param orderId
     * @return
     */
    @GetMapping("/{orderId}")
    public ModelAndView detail(@PathVariable("orderId") Long orderId) {
        ModelMap modelMap = new ModelMap();
        modelMap.put("orderId", orderId);
        return new ModelAndView(prefix + "/detail");
    }
}
