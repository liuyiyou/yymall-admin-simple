package cn.liuyiyou.shop.pay;

/**
 */
public interface Processor<IN, OUT, ACCESSARY> {

    OUT process(final IN in, ACCESSARY accessary) throws Exception;
}
