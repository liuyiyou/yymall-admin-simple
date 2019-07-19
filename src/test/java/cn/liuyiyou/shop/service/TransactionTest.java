package cn.liuyiyou.shop.service;

import cn.liuyiyou.shop.AbstractTest;
import cn.liuyiyou.shop.prod.entity.Prod;
import cn.liuyiyou.shop.prod.entity.ProdSku;
import cn.liuyiyou.shop.prod.service.IProdService;
import cn.liuyiyou.shop.prod.service.IProdSkuService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: liuyiyou.cn
 * @date: 2019/7/19
 * @version: V1.0
 */
public class TransactionTest extends AbstractTest {


    @Autowired
    private IProdSkuService prodSkuService;
    @Autowired
    private IProdService prodService;

    @Test
    public void testSuccess(){
        Prod prod = new Prod();
        prod.setProdId(201911111L);
        prodService.save(prod);
        prodSkuService.save(new ProdSku());
    }
}
