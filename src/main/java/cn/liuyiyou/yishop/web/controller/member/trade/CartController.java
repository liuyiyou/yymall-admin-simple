
package cn.liuyiyou.yishop.web.controller.member.trade;

import cn.liuyiyou.yishop.web.form.member.trade.CartForm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/member/trade/")
public class CartController {

	public static Logger logger = LoggerFactory.getLogger(CartController.class);
	
    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String cart(@ModelAttribute("form") CartForm form) {
    	logger.info("aceess in cart");
        return "member/trade/cart";

    }

}
