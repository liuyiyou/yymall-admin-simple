/**
 * 
 * Copyright © 2014 liuyiyou.cn版权所有
 */
package cn.liuyiyou.yishop.web.form;

import cn.liuyiyou.yishop.entity.Category;
import cn.liuyiyou.yishop.entity.Product;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author liuyiyou
 *
 */
public class IndexForm extends BaseForm {

    private List<Category>             categories;

    private Map<String, List<Product>> productsByChannel;

   
    public List<Category> getCategories() {
        return categories;
    }

   
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    
    public Map<String, List<Product>> getProductsByChannel() {
        return productsByChannel;
    }

   
    public void setProductsByChannel(Map<String, List<Product>> productsByChannel) {
        this.productsByChannel = productsByChannel;
    }

}
