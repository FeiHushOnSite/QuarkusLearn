package com.course;

import com.course.bean.NormalApplicationScoped;
import com.course.bean.NormalSingleton;
import io.quarkus.logging.Log;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

/**
 * @program: quarkus-course
 * @className: ChangeLazyLogicTest
 * @description:
 * @author:
 * @create: 2022-12-19 14:05
 * @Version 1.0
 **/
@QuarkusTest
public class ChangeLazyLogicTest {

    @Inject
    NormalSingleton normalSingleton;

    @Inject
    NormalApplicationScoped normalApplicationScoped;

    @Test
    void ping() {
        Log.info("start invoke normalSingleton.ping");
        normalSingleton.ping();
        Log.info("start invoke normalApplicationScoped.ping");
        normalApplicationScoped.ping();
    }
}
