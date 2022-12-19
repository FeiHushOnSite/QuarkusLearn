package com.course.interceptor.impl;

import com.course.interceptor.Notification;
import com.course.interceptor.define.SendMessage;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * @program: quarkus-course
 * @className: SendMessageBySmtp
 * @description: 短信通知
 * @author:
 * @create: 2022-12-19 14:53
 * @Version 1.0
 **/
@ApplicationScoped
@Named("sms")
public class SendMessageBySms implements Notification {

    @SendMessage
    @Override
    public String sendNotification() {
        return "send notification by sms";
    }
}
