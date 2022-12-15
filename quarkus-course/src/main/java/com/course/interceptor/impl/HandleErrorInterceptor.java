package com.course.interceptor.impl;

import com.course.interceptor.define.HandleError;
import io.quarkus.arc.Priority;
import io.quarkus.logging.Log;

import javax.interceptor.AroundConstruct;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * @program: QuarkusLearn
 * @className: HandleErrorInterceptor
 * @description: 1。被AroundConstruct注解修饰后，execute方法会在bean的构造方法执行被调用
 * 2. context.getTarget()的返回值，只有在context.proceed执行后才不为空
 * @author:
 * @create: 2022-12-14 11:41
 * @Version 1.0
 **/
@HandleError
@Interceptor
@Priority(Interceptor.Priority.APPLICATION + 1)
public class HandleErrorInterceptor {

    @AroundConstruct
    void execute(InvocationContext context) throws Exception {
        //执行业务逻辑
        Log.infov("start construction interceptor");

        //执行bean 的构造方法
        context.proceed();

        //注意，对于context.getTarget()的返回值，此时不是null,如果在context.proceed()之前，则是null
        Log.infov("bean instance of {0}", context.getTarget().getClass().getSimpleName());
    }
}
