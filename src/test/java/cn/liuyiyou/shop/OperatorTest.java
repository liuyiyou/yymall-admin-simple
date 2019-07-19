package cn.liuyiyou.shop;

/**
 * @author: liuyiyou.cn
 * @date: 2019/7/18
 * @version: V1.0
 */
public class OperatorTest {

    public static void main(String[] args) {
        boolean a = false;
        boolean b = true;
        boolean c = false;
        System.out.println(a || b && c); //true

        System.out.println(a || (b && c));
    }
}
