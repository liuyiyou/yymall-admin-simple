
package cn.liuyiyou.yishop.web.controller.member.trade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.liuyiyou.yishop.web.form.member.trade.FavoriteForm;

@Controller
@RequestMapping(value = "/member/trade/")
public class FavoriteController {
	
	private static final Logger logger = LoggerFactory.getLogger(FavoriteController.class);

    @RequestMapping(value = "/favorites", method = RequestMethod.GET)
    public String favorites(@ModelAttribute("form") FavoriteForm form) {
    	logger.info("进入我喜欢的");
        return "member/trade/favorites";

    }

}
