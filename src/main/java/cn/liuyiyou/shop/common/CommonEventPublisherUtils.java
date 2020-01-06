package cn.liuyiyou.shop.common;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Utils - 事件发布
 */
@Component("commonEventPublisherUtils")
public class CommonEventPublisherUtils implements ApplicationEventPublisherAware {

    private static ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        CommonEventPublisherUtils.applicationEventPublisher = applicationEventPublisher;
    }

    public static void publishEvent(ApplicationEvent event) {
        publishEvent((Object)event);
    }

    public static void publishEvent(Object event) {
        Assert.notNull(applicationEventPublisher);
        applicationEventPublisher.publishEvent(event);
    }
}
