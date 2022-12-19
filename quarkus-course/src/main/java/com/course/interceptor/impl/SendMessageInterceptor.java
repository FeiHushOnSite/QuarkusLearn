package com.course.interceptor.impl;

import com.course.interceptor.define.SendMessage;
import io.quarkus.arc.runtime.InterceptorBindings;
import io.quarkus.logging.Log;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @program: quarkus-course
 * @className: SendMessageInterceptor
 * @description:
 * @author:
 * @create: 2022-12-19 15:02
 * @Version 1.0
 **/
@SendMessage
@Interceptor
public class SendMessageInterceptor {

    @AroundInvoke
    Object execute(InvocationContext context) throws Exception {
        // 先执行被拦截的方法
        Object rlt = context.proceed();
        // 获取被拦截的方法的类名
        String interceptedClass = context.getTarget().getClass().getSimpleName();

        //这里代表被拦截的方法已经执行成功，未出现异常
        //从context中获取通知类型，由于允许重复注解，因此通知类型可能有多个
        List<String> allTypes = getAllTypes(context);

        // 将所有消息类型打印出来
        Log.infov("{0} messageTypes : {1}", interceptedClass, allTypes);

        //将所有消息类型打印出来
        for (String type : allTypes) {
            switch (type) {
                case "sms":
                    sendSms();
                    break;
                case "email":
                    sendEmail();
                    break;
                case "allType":
                    sendAllType();
                    break;
            }
        }
        //最后返回方法执行结果
        return rlt;
    }

    /**
     * 从InvocationContext中取出所有注解，过滤出SendMessage类型的，将它们的type属性放入List中返回
     * @param invocationContext
     * @return
     */
    private List<String> getAllTypes(InvocationContext invocationContext) {
        //取出所有注解
        Set<Annotation> bindings = InterceptorBindings.getInterceptorBindings(invocationContext);
        List<String> allTypes = new ArrayList<>();
        for (Annotation binding : bindings) {
            if (binding instanceof SendMessage) {
                allTypes.add(((SendMessage) binding).sendType());
            }
        }
        return allTypes;
    }

    /**
     * 模拟发送短信
     */
    private void sendSms() {
        Log.info("operating success, from sms");
    }

    /**
     * 模拟发送邮件
     */
    private void sendEmail() {
        Log.info("operating success, from email");
    }

    /**
     * 模拟发送短信和邮件
     */
    private void sendAllType() {
        Log.info("operating success, from sms and email");
    }
}
