package com.course.bean;

import io.quarkus.logging.Log;
import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

/**
 * @program: quarkus-course
 * @interfaceName: NormalApplicationScoped
 * @description:  懒加载、StartupEvent、Startup这三种情况下的实例化顺序各不相同
 * 懒加载           ｜   StartupEvent注解   ｜  Startup注解      ｜
 * ----------------｜---------------------｜-------------------｜
 * quarkus框架初始化 ｜    quarkus框架初始化  ｜quarkus框架初始化   ｜
 * 无              ｜    常规作用域的bean    ｜ 常规作用域的bean代理｜
 *                 ｜                     ｜   常规作用域的bean  ｜
 * ----------------｜---------------------｜-------------------｜
 * 注入bean         |    注入bean           |     注入bean       |
 *  伪作用域的bean   |    伪作用域的bean      |    伪作用域的bean   |
 * 常规作用域的bean代理类｜常规作用域的bean代理类｜                   ｜
 * ----------------｜---------------------｜-------------------｜
 * bean的方法被调用  ｜    bean的方法被调用    ｜    bean的方法被调用 ｜
 * 常规作用域的bean--｜       无             ｜        无         ｜
 * ----------------｜---------------------｜-------------------｜
 * @author:
 * @create: 2022-12-19 14:08
 * @Version 1.0
 **/
@ApplicationScoped
@Startup
public class NormalApplicationScoped {

    public NormalApplicationScoped() {
        Log.info("Construction from " + this.getClass().getSimpleName() + "\n");
    }

    public String ping() {
        return "ping from NormalApplicationScoped\n";
    }

//    void startup(@Observes StartupEvent event) {
//        Log.info("receive StartupEvent");
//    }
}
