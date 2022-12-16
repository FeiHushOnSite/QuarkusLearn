package com.course.interceptor.impl;

import com.course.interceptor.define.TrackLifeCycle;
import io.quarkus.arc.Priority;
import io.quarkus.logging.Log;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.AroundConstruct;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * @program: QuarkusLearn
 * @className: LifeCycleInterceptor
 * @description: 用注解Interceptor和TrackLifeCycle修饰，说明这是拦截器TracklifeCycle的实现
 * 被拦截bean实例化的时候，AroundConstruct修饰的方法execute就会被执行，和拦截器里的AroundInvoke很相似
 * @author:
 * @create: 2022-12-16 10:29
 * @Version 1.0
 **/
@TrackLifeCycle
@Interceptor
@Priority(Interceptor.Priority.APPLICATION + 1)
public class LifeCycleInterceptor {

    @AroundConstruct
    void execute(InvocationContext context) throws Exception {
        Log.info("start AroundConstruct");
        try {
            context.proceed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.info("end AroundConstruct");
    }

    @PostConstruct
    public void doPostConstruct(InvocationContext ctx) {
        Log.info("life cycle PostConstruct");
    }

    @PreDestroy
    public void doPreDestroy(InvocationContext ctx) {
        Log.info("life cycle PreDestroy");
    }
}
