package com.course;

import com.course.service.TrackParamsDemo;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

/**
 * @program: QuarkusLearn
 * @className: InterceptorTest
 * @description:
 * @author:
 * @create: 2022-12-14 13:24
 * @Version 1.0
 **/
@QuarkusTest
public class InterceptorTest {

    @Inject
    TrackParamsDemo trackParamsDemo;

    @Test
    public void testTrackParams() {
        trackParamsDemo.trackParamsDemo("Jerry", 101);
    }
}
