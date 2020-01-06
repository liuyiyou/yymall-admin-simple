package cn.liuyiyou.shop.pay.event;

import cn.liuyiyou.shop.vo.RefundVo;
import org.springframework.context.ApplicationEvent;


/**
 *
 */
public class RefundEvent extends ApplicationEvent {

    private static final long serialVersionUID = 8146908156165645655L;

    public RefundEvent(RefundVo source) {
        super(source);
    }

    public RefundVo getRefund() {
        return (RefundVo) getSource();
    }
}
