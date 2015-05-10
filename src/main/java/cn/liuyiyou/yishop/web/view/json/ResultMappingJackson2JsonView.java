/**
 * 
 * 惠购 - 惠购网 - www.huiget.com - 特别会购！
 * Copyright © 2014 惠购 www.huiget.com 版权所有
 */
package cn.liuyiyou.yishop.web.view.json;

import cn.liuyiyou.yishop.web.form.BaseForm;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author yaofang
 * @version $Id: ResultMappingJackson2JsonView.java, v 0.1 2014年10月3日 上午10:12:30 yaofang Exp $
 */
public class ResultMappingJackson2JsonView extends MappingJackson2JsonView {

    /** 
     * @see org.springframework.web.servlet.view.json.MappingJackson2JsonView#filterModel(java.util.Map)
     */
    @Override
    protected Object filterModel(Map<String, Object> model) {
        Map<String, Object> result = new HashMap<String, Object>(model.size());

        for (Map.Entry<String, Object> entry : model.entrySet()) {
            if (entry.getValue() instanceof BaseForm || entry.getValue() instanceof BindingResult) {
                continue;
            }

            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

}
