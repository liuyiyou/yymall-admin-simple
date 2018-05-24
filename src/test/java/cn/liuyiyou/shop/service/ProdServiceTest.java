package cn.liuyiyou.shop.service;

import cn.liuyiyou.shop.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/***
 * @author: liuyiyou
 * @date: 2018/4/4
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class ProdServiceTest {

    @Autowired
    private IProdService prodService;

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void selectByPrimaryKey() {
    }


    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void getProdsPage() {
        System.out.println(prodService.getProdsPage(1,10).getList().size());
    }
}