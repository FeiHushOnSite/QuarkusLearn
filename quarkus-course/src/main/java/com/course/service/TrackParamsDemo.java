package com.course.service;

import com.course.interceptor.define.TrackParams;
import io.quarkus.logging.Log;

import javax.enterprise.context.ApplicationScoped;

/**
 * @program: QuarkusLearn
 * @className: TrackParamsDemo
 * @description:
 * @author:
 * @create: 2022-12-14 13:25
 * @Version 1.0
 **/
@ApplicationScoped
@TrackParams
public class TrackParamsDemo {

    public void trackParamsDemo(String name, int id) {
        Log.infov("Hello {0}, your id is {1}", name, id);
    }
}
