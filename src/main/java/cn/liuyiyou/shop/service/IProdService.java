package cn.liuyiyou.shop.service;

import cn.liuyiyou.shop.entity.Prod;
import com.github.pagehelper.PageInfo;

/***
 * @author: liuyiyou
 * @date: 2018/4/4
 */
public interface IProdService {

    PageInfo<Prod> getProdsPage(int page, int pageSize);

    int insert(Prod record);


    Prod selectByPrimaryKey(Long prodId);


    int updateByPrimaryKey(Prod record);
}
