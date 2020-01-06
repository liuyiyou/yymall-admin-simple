package cn.liuyiyou.shop.vo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;


@Data
public class RefundVo {

    /**
     * 当前登录人后台人员
     */
    private Integer suid;

    /** 前台用户 */
    private Integer uid;

    /**
     * 订单id
     */
    private Long subsId;

    /**
     * 退款金额
     */
    private Float refundAmount;


    /** 支付方式 */
    private Byte payType;

    /**
     * 参数
     */
    private Map<String, String> params = new HashMap<>();

    /** 扩展参数 */
    private Map<String, Object> extParams = new HashMap<>();




}
