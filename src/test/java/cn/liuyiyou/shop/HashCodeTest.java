package cn.liuyiyou.shop;

import cn.liuyiyou.shop.entity.Subs;
import io.jsonwebtoken.lang.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liuyiyou.cn
 * @date: 2019/7/19
 * @version: V1.0
 */
public class HashCodeTest {


//        subs.setName("2");

    /**
     * 模拟操作
     */
    @Test
    public void testNomralHashCode() {
        Map<Subs, String> subsStringMap = new HashMap<>();
        Subs subs = new Subs();
        subs.setId(1);
        subs.setName("1");
        subsStringMap.put(subs, "1");
        //中途修改key中的值
        subs.setName("2");
        String s = subsStringMap.get(subs);
        Assert.notNull(s);
    }
}
