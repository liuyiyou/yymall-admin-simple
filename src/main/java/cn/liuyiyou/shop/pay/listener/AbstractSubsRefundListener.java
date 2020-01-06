package cn.liuyiyou.shop.pay.listener;

import cn.liuyiyou.shop.pay.event.RefundEvent;
import cn.liuyiyou.shop.vo.RefundVo;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

import java.util.Objects;

/**
 * Listener - 抽象退款listener
 *
 */
@Slf4j
public abstract class AbstractSubsRefundListener implements ApplicationListener<RefundEvent> {

    @Override
    public void onApplicationEvent(RefundEvent event) {
        RefundVo vo = event.getRefund();
        log.error("接收到 '发起退款' 事件, refundVo = " + vo.toString());
        JSONObject result = JSONObject.parseObject(vo.getParams().get("result"));
        if (!isSuccess(result)) {
            log.error("退款失败....subsId=" + vo.getSubsId());
            onFailRefund(vo);
        } else {
            log.error("退款成功,处理相关状态...subsId="+vo.getSubsId());
            onSuccessRefund(vo);
        }
    }

    protected abstract void onSuccessRefund(RefundVo vo);

    protected void onFailRefund(RefundVo vo) {
        log.error(vo.getParams().get("result"));
    }

    private boolean isSuccess(JSONObject result) {
        return Objects.nonNull(result) && Objects.equals(result.getInteger("resultCode"), 200);
    }
}
