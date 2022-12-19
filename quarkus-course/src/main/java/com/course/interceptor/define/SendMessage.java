package com.course.interceptor.define;

import javax.enterprise.util.Nonbinding;
import javax.interceptor.InterceptorBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@InterceptorBinding
@Repeatable(SendMessage.SendMessageList.class)
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SendMessage {

    /**
     * 消息类型 : "sms"表示短信，"email"表示邮件
     * @return
     */
    @Nonbinding
    String sendType() default "sms";

    @Target({ElementType.TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @interface SendMessageList {
        SendMessage[] value();
    }
}
