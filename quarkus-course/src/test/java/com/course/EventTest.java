package com.course;

import com.course.event.Consumer;
import com.course.event.MultiChannelWithMultiEvent;
import com.course.event.Producer;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

/**
 * @program: QuarkusLearn
 * @className: EventTest
 * @description:
 * @author:
 * @create: 2022-12-14 14:04
 * @Version 1.0
 **/
@QuarkusTest
public class EventTest {

    @Inject
    Producer producer;

    @Inject
    Consumer consumer;

    @Inject
    MultiChannelWithMultiEvent multiChannelWithMultiEvent;

    @Test
    public void testSync() {
        Assertions.assertEquals(1, producer.syncProduce("testSync"));
    }

    @Test
    public void testAsync() throws InterruptedException {
        Assertions.assertEquals(0, producer.asyncProduce("testAsync"));
        Thread.sleep(150);
        //发送完信息后立即执行后续代码，不等待信息
        //消费事件是另外一个线程中进行的
        //消费结束后的回调，不在主线程，也不在消费事件的线程！！！
    }

    @Test
    public void testMultiChannelMultiEvent() {
        //对管理员来说
        //adminEvent消费时计数加2
        //allEvent消费时加1
        //所以最终统计数是3
        Assertions.assertEquals(4, multiChannelWithMultiEvent.produceAdmin("admin"));

        //对普通人来说
        //normalEvent消费计数加1
        //allEvent消费计数加1
        //所以最终计数是2
        Assertions.assertEquals(3, multiChannelWithMultiEvent.produceNormal("normal"));
    }
}
