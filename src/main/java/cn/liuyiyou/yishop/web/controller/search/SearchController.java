/**
 * 
 * 惠购 - 惠购网 - www.huiget.com - 特别会购！
 * Copyright © 2014 惠购 www.huiget.com 版权所有
 */
package cn.liuyiyou.yishop.web.controller.search;

import cn.liuyiyou.yishop.service.CategoryService;
import cn.liuyiyou.yishop.web.form.search.SearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author yaofang
 * @version $Id: SearchController.java, v 0.1 2014年10月7日 上午11:08:31 yaofang Exp $
 */
@Controller
public class SearchController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/search")
    public String search(@ModelAttribute("form") SearchForm form) {

        return "search/search";

    }

    @RequestMapping("/catalog/{catName}")
    public String category(@ModelAttribute("form") SearchForm form) {
        form.setCategory(categoryService.findByNameUrl(form.getCatName()));

        return "search/catalog";

    }

}
