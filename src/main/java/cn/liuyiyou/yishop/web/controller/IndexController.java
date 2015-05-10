package cn.liuyiyou.yishop.web.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.liuyiyou.yishop.entity.Category;
import cn.liuyiyou.yishop.entity.Channel;
import cn.liuyiyou.yishop.entity.Product;
import cn.liuyiyou.yishop.service.CategoryService;
import cn.liuyiyou.yishop.service.ChannelService;
import cn.liuyiyou.yishop.service.ProductService;
import cn.liuyiyou.yishop.web.form.IndexForm;


/**
 * 首页
 * @author liuyiyou
 *
 */
@Controller
public class IndexController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ChannelService channelService;
    
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(@ModelAttribute("form") IndexForm form) {

    	//所有频道
        Map<String, Channel> allChannel = channelService.getAllChannel();
        form.setAllChannel(allChannel);
        
        //所有类目
        List<Category> allCategory = categoryService.findByParentIdAndStatus(0, "1");
        
        for(Category category:allCategory){
        	List<Category> subCategories = categoryService.findByParentIdAndStatus(category.getId(),"1");
        	category.setSubCategories(subCategories);
        }
        
        
        form.setCategories(allCategory);

        //频道的产品
        Map<String, List<Product>> productsByChannel = new LinkedHashMap<String, List<Product>>();
        for (String channel : allChannel.keySet()) {
        	System.out.println(channel);
        	System.out.println("size:"+productService.findProductsForIndex(channel, 0, 12));
            productsByChannel.put(channel, productService.findProductsForIndex(channel, 0, 12));
        }
        form.setProductsByChannel(productsByChannel);
        
        

        return "index";
    }
    
    @RequestMapping(value="/test")
    @ResponseBody
    public List<Category> test(){
    	 //所有类目
        List<Category> allCategory = categoryService.findByParentIdAndStatus(0, "1");
        return allCategory;
    }
}
