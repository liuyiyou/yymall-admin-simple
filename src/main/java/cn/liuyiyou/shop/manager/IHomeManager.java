package cn.liuyiyou.shop.manager;

import cn.liuyiyou.shop.resp.Result;

/***
 * @author: liuyiyou
 * @date: 2018/5/25
 */
public interface IHomeManager {

    Result getHomePage(int page, int pageSize);
}
