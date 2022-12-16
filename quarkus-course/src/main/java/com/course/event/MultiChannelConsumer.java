package com.course.event;

import com.course.event.intonnation.Admin;
import com.course.event.intonnation.Normal;
import io.quarkus.logging.Log;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.EventMetadata;


import java.lang.annotation.Annotation;
import java.util.Set;

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
     * 1. 给allEvent方法增加一个入参，类型是EventMetadata, bean容器会将事件的元数据设置到此参数
     * 2。EventMetadata的getType方法能取得事件类型
     * 3. EventMetadata的getType方法能取得事件的所有修饰注解，包括Admin或者Normal
     */
    public void allEvent(@Observes ProjectEvent event, EventMetadata eventMetadata) {
        Log.infov("receive event (no Qualifier), {0}", event);

        Log.infov("event type: {0}", eventMetadata.getType());

        //获取该事件的所有注解
        Set<Annotation> qualifiers = eventMetadata.getQualifiers();

        //将事件的所有注解逐个打印
        if(null != qualifiers) {
            qualifiers.forEach(annotation -> Log.infov("qualify: {0}", annotation));
        }
        //计数加1
        event.addNum();
    }
}
