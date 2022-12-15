package com.course.event;

import com.course.event.intonnation.Admin;
import com.course.event.intonnation.Normal;
import io.quarkus.logging.Log;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

/**
 * @program: QuarkusLearn
 * @className: MultiChannelConsumer
 * @description:
 * @author:
 * @create: 2022-12-14 14:41
 * @Version 1.0
 **/
@ApplicationScoped
public class MultiChannelConsumer {

    public void adminEvent(@Observes @Admin ProjectEvent event) {
        Log.infov("receive admin event, {0}", event);
        //管理员的计数增加两次，方便单元测试验证
        event.addNum();
        event.addNum();
    }

    public void normalEvent(@Observes @Normal ProjectEvent event) {
        Log.infov("receive normal event, {0}", event);
        //计数加1
        event.addNum();
    }

    /**
     * 如果不用注释修饰，所有event类型事件都会在次被消费
     */
    public void allEvent(@Observes ProjectEvent event) {
        Log.infov("receive event (no Qualifier), {0}", event);
        //计数加1
        event.addNum();
    }
}
