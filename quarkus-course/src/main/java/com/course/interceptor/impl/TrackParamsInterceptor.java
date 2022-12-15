package com.course.interceptor.impl;

import com.course.interceptor.define.TrackParams;
import io.quarkus.arc.Priority;
import io.quarkus.logging.Log;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.Arrays;
import java.util.Optional;

/**
 * @program: QuarkusLearn
 * @className: TrackParamsInterceptor
 * @description:
 * @author:
 * @create: 2022-12-14 13:16
 * @Version 1.0
 **/
@TrackParams
@Interceptor
@Priority(Interceptor.Priority.APPLICATION + 1)
public class TrackParamsInterceptor {

    @AroundInvoke
    Object execute(InvocationContext context) throws Exception {

        //context.getParameters()返回拦截方法的所有参数
        // 用Optional 处理非空时的数组
        Optional.of(Arrays.stream(context.getParameters()))
                .ifPresent(stream -> stream
                        .forEach(object -> Log.infov("parameter type [{0}], value [{1}]",
                                object.getClass().getSimpleName(), object)));
        return context.proceed();
    }
}
