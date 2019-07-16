package cn.liuyiyou.shop;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

/**
 * @author: liuyiyou.cn
 * @date: 2019/7/14
 * @version: V1.0
 */
public class Price {

    private Double probability;

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

    public static void main(String[] args) {
        List<Price> list = new ArrayList<>();
        Price price1 = new Price();
        price1.setProbability(2.5);
        list.add(price1);

        Price price2 = new Price();
        price2.setProbability(33.3);
        list.add(price2);

        Price price3 = new Price();
        price3.setProbability(0.0);
        list.add(price3);

        Price price4 = new Price();
        price4.setProbability(21.2);
        list.add(price4);

        Price price5 = new Price();
        price5.setProbability(21.2);
        list.add(price5);

        Price price6 = new Price();
        price6.setProbability(0.4);
        list.add(price6);

        Price price7 = new Price();
        price7.setProbability(21.2);
        list.add(price7);

        Price price8 = new Price();
        price8.setProbability(0.3);
        list.add(price8);
        System.out.println(list.size());

        Double sum = list.stream().filter(e-> nonNull(e.getProbability())).mapToDouble(Price::getProbability).sum();
        System.out.println(sum);
        System.out.println(new Double(100).equals(sum));


    }
}
