package cn.liuyiyou.shop.pay;

import cn.liuyiyou.shop.common.CommonEventPublisherUtils;
import cn.liuyiyou.shop.order.config.OrderPayTypeMap;
import cn.liuyiyou.shop.pay.event.RefundEvent;
import cn.liuyiyou.shop.vo.RefundVo;
import org.apache.commons.lang.StringUtils;

/**
 * @author: liuyiyou.cn
 * @date: 2020/1/6
 * @version: V1.0
 */
public class RefundService {


    private String doRefund(RefundVo refundVo, OrderPayTypeMap payType) {
        String result = StringUtils.EMPTY;
//        try {
//            result = refundClientMap.get(payType.toString()).refund(refundVo.getParams(), httpClient);
//        } finally {
//            refundVo.getParams().put("result", result);
//            logger.error("发送 '发起退款' 事件, refundVo = " + refundVo.toString());
//            publishEvent(new RefundEvent(refundVo));
//        }
        return result;
    }


    private void publishEvent(RefundEvent event) {
        CommonEventPublisherUtils.publishEvent(event);
    }
}
