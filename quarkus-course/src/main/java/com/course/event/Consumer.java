package com.course.event;

import io.quarkus.logging.Log;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.ObservesAsync;

/**
 * @program: QuarkusLearn
 * @className: Consumer
 * @description:
 * @author:
 * @create: 2022-12-14 13:58
 * @Version 1.0
 **/
@ApplicationScoped
public class Consumer {

    public void syncConsume(@Observes ProjectEvent projectEvent) {
        Log.infov("receive sync event, {0}", projectEvent);

        //模拟业务执行，耗时100毫秒
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //计数加1
        projectEvent.addNum();
    }

    public void asyncConsume(@ObservesAsync ProjectEvent projectEvent) {
        Log.infov("receive async event, {0}", projectEvent);

        //模拟业务执行，耗时100毫秒
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //计数加1
        projectEvent.addNum();
    }
}
