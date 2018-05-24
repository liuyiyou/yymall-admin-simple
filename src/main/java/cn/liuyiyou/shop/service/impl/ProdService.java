package cn.liuyiyou.shop.service.impl;

import cn.liuyiyou.shop.entity.Prod;
import cn.liuyiyou.shop.mapper.ProdMapper;
import cn.liuyiyou.shop.service.IProdService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * @author: liuyiyou
 * @date: 2018/4/4
 */
@Service
public class ProdService implements IProdService{

    @Autowired
    private ProdMapper prodMapper;

    @Override
    public PageInfo<Prod> getProdsPage(int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Prod> prods = prodMapper.selectByExample(null);
        PageInfo<Prod> prodPageInfo = new PageInfo<>(prods);
        return prodPageInfo;
    }

    @Override
    public int insert(Prod record) {
        return 0;
    }

    @Override
    public Prod selectByPrimaryKey(Long prodId) {
        return prodMapper.selectByPrimaryKey(prodId);
    }



    @Override
    public int updateByPrimaryKey(Prod record) {
        return 0;
    }
}
