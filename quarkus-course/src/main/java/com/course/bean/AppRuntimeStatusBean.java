package com.course.bean;

import javax.enterprise.context.ApplicationScoped;

/**
 * @program: QuarkusLearn
 * @className: AppRuntimeStatusBean
 * @description:
 * @author:
 * @create: 2022-12-13 14:58
 * @Version 1.0
 **/
@ApplicationScoped
public class AppRuntimeStatusBean {

    public String startupStatus() {
        return "hello, this app is open..";
    }

    public String terminationStatus() {
        return "bye bye, this app is close";
    }
}
