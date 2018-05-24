package cn.liuyiyou.shop.mapper;

import cn.liuyiyou.shop.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/***
 * @author: liuyiyou
 * @date: 2018/4/4
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class ProdMapperTest {//extends AbstractTest{

    @Autowired
    private ProdMapper prodMapper;


    @Test
    public void insert() {
    }

    @Test
    public void selectByPrimaryKey() {
        Assert.assertNotNull(prodMapper.selectByPrimaryKey(210101008L));
    }


    @Test
    public void updateByPrimaryKey() {
    }
}