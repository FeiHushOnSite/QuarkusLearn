package com.course.interceptor.impl;

import com.course.interceptor.Notification;
import com.course.interceptor.define.SendMessage;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * @program: quarkus-course
 * @className: SendMessageByEmail
 * @description:
 * @author:
 * @create: 2022-12-19 14:54
 * @Version 1.0
 **/
@ApplicationScoped
@Named("email")
public class SendMessageByEmail implements Notification {

    @SendMessage(sendType = "email")
    @Override
    public String sendNotification() {
        return "send message by email";
    }
}
