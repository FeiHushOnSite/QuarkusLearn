package com.course;

import com.course.interceptor.impl.SendMessageByAll;
import com.course.interceptor.impl.SendMessageByEmail;
import com.course.interceptor.impl.SendMessageBySms;
import io.quarkus.logging.Log;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Named;

/**
 * @program: quarkus-course
 * @className: SendMessageTest
 * @description:
 * @author:
 * @create: 2022-12-19 15:18
 * @Version 1.0
 **/
@QuarkusTest
public class SendMessageTest {

    @Named("sms")
    SendMessageBySms sendMessageBySms;

    @Named("email")
    SendMessageByEmail sendMessageByEmail;

    @Named("allType")
    SendMessageByAll sendMessageByAll;

    @Test
    public void testSendMessage() {

        sendMessageBySms.sendNotification();
        Log.info("\n");
        sendMessageByEmail.sendNotification();
        Log.info("\n");
        sendMessageByAll.sendNotification();
        Log.info("\n");

    }
}
