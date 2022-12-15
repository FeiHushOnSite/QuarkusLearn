package com.course.event;

import io.quarkus.logging.Log;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 * @program: QuarkusLearn
 * @className: Producer
 * @description:
 * @author:
 * @create: 2022-12-14 13:48
 * @Version 1.0
 **/

@ApplicationScoped
public class Producer {

    @Inject
    Event<ProjectEvent> projectEvent;

    /**
     * 发布同步消息
     * 注意: 注入Event，用于发布事件，通过泛型指定事件类型是thisEvent
     * 发布同步事件很简单，调用fire即可
     * 由于是同步事件，会等待事件的消费者将消费的代码执行完毕后，fire方法才会返回
     * 如果消费者增加了thisEvent的记数，那么thisEvent.getNum()应该等于计数的调用次数
     * @param source 消息源
     * @return 被消费次数
     */
    public int syncProduce(String source) {
        ProjectEvent thisEvent = new ProjectEvent("syncEvent");
        Log.infov("before sync fire, {0}", thisEvent);
        projectEvent.fire(thisEvent);
        Log.infov("after sync fire, {0}", thisEvent);
        return thisEvent.getNum();
    }

    /**
     * 发布异步事件
     * 为了避免事件消耗时过长对事件发送的线程造成影响，可以使用异步事件
     * 注意：fireAsync是发送异步事件的方法
     * fireAsync的返回值是CompletionStage, 我们可以调用其handleAsync方法，将响应逻辑(对事件消费结果的处理)传入，
     * 这段响应逻辑会在事件消费结束后被执行，检验是否有异常，有就打印异常
     * @param source 消息源
     * @return 被消费次数
     */
    public int asyncProduce(String source) {
        ProjectEvent thisEvent = new ProjectEvent("asyncEvent");
        Log.infov("before async fire, {0}", thisEvent);
        projectEvent.fireAsync(thisEvent)
                .handleAsync((e, error) -> {
                    if(null != error) {
                        Log.error("handle error", error);
                    } else {
                        Log.infov("finish handle, {0}", thisEvent);
                    }
                    return null;
                });
        Log.infov("after async fire, {0}", thisEvent);
        return thisEvent.getNum();
    }
}
