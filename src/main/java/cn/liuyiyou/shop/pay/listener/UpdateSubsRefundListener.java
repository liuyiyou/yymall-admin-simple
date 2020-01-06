package cn.liuyiyou.shop.pay.listener;

import cn.liuyiyou.shop.order.entity.Order;
import cn.liuyiyou.shop.order.enums.OrderStatusEnum;
import cn.liuyiyou.shop.order.service.IOrderService;
import cn.liuyiyou.shop.pay.Processor;
import cn.liuyiyou.shop.pay.event.RefundEvent;
import cn.liuyiyou.shop.vo.RefundVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Listener - 退款后更新订单
 *
 * @author IBA TEAM.
 * @date 2017/3/30 20:14
 */
@Component("updateSubsRefundNotifier")
@Slf4j
public class UpdateSubsRefundListener extends AbstractSubsRefundListener {

    @Autowired
    private IOrderService subsService;

    @Async
    @Override
    public void onApplicationEvent(RefundEvent event) {
        super.onApplicationEvent(event);
    }

    @Override
    protected void onSuccessRefund(RefundVo vo) {
        constructRefundProcessor().process(vo.getSubsId(), null);
    }

    private DrawSubsRefundProcessor constructRefundProcessor() {
        return new DrawSubsRefundProcessor();
    }

    private class DrawSubsRefundProcessor implements Processor<Long, Boolean, ObjectUtils.Null> {
        @Override
        public Boolean process(Long subsId, ObjectUtils.Null accessary) {
            Order subs = subsService.getById(subsId);
            log.error("订单[" + subs.getOrderId() + "]退款中... subs.getStatus() = " + subs.getStatus());
            if (resolveValid(subs)) {
                subsService.updateById(subs);
                log.error("订单[" + subs.getOrderId() + "]已退款完成");
            }
            return true;
        }

        private boolean resolveValid(Order subs) {
            log.error("判断订单[" + subs.getOrderId() + "]修改为退款完成状态是否合法..subs.getStatus() = " + subs.getStatus());
            return Objects.nonNull(subs) && Objects.equals(subs.getStatus(), OrderStatusEnum.CANCEL.getCode());
        }
    }
}
