package com.course.interceptor.impl;

import com.course.interceptor.Notification;
import com.course.interceptor.define.SendMessage;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * @program: quarkus-course
 * @className: SendMessageByAll
 * @description:
 * @author:
 * @create: 2022-12-19 14:56
 * @Version 1.0
 **/
@ApplicationScoped
@Named("allType")
public class SendMessageByAll implements Notification {

    @SendMessage(sendType = "allType")
    @Override
    public String sendNotification() {
        return "send message by sms and email";
    }
}
