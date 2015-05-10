package cn.liuyiyou.yishop.web.controller.product;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.liuyiyou.yishop.entity.Channel;
import cn.liuyiyou.yishop.entity.Product;
import cn.liuyiyou.yishop.service.ChannelService;
import cn.liuyiyou.yishop.service.ProductService;
import cn.liuyiyou.yishop.web.form.product.ProductForm;


@Controller
@RequestMapping("/product")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	

    @Autowired
    private ProductService productService;
    
    
    @RequestMapping(value="/{id}")
    public String item(@PathVariable("id")Integer id,ModelMap map){
    	Product product = productService.findById(id);
    	map.put("product",product);
    	return "product/product";
    }

    @Autowired
    private ChannelService channelService;

    @RequestMapping(value = "/channel/{channelName}", method = RequestMethod.GET)
    public String channel(@ModelAttribute("form") ProductForm form) {
        Map<String, Channel> allChannel = channelService.getAllChannel();
        form.setAllChannel(allChannel);
        Channel channel = allChannel.get(form.getChannelName());
        form.setChannel(channel);
        if (channel == null) {
            return "redirect:/";
        }

        int count = productService.count(channel.getName(), form.getCategory());
        form.setCount(count);
        if (count > 0) {
            int pageSize = form.getPageSize();

            form.setTotalPageNumber(count % pageSize == 0 ? count / pageSize : count / pageSize + 1);

            form.setProducts(productService.findProductsByConditionForPage(channel.getName(), form.getCategory(), form.getPageSize(), form.getPageNumber()));

            form.setCategories(productService.findCategoryByChannel(channel.getName()));
        }

        return "product/channel";
    }

}
