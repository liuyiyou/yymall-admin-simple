package cn.liuyiyou.shop.order.controller.admin;

import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/list")
    public ModelAndView list() {
        return new ModelAndView(prefix + "/order");
    }
}
