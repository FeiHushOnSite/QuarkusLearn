package com.course.bean;

import io.quarkus.logging.Log;

import javax.inject.Singleton;

/**
 * @program: quarkus-course
 * @className: NormalSingleton
 * @description: lazy instantiation 懒加载
 * @author:
 * @create: 2022-12-19 14:06
 * @Version 1.0
 **/
@Singleton
public class NormalSingleton {

    public NormalSingleton() {
        Log.info("Construction from " + this.getClass().getSimpleName());
    }

    public String ping() {
        return "ping from NormalSingleton";
    }
}
