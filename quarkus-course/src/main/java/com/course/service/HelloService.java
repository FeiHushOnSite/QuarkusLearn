package com.course.service;

import io.quarkus.cache.CacheResult;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

/**
 * @program: QuarkusLearn
 * @className: HelloService
 * @description:
 * @author:
 * @create: 2022-12-13 16:24
 * @Version 1.0
 **/
@ApplicationScoped
public class HelloService {

    @ConfigProperty(name = "hello.message")
    String message;

    @ConfigProperty(name = "hello.name", defaultValue = "reng")
    String helloName;

    @CacheResult(cacheName = "hello-cache")
    public String getHello() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
        return "获取" + message + "的时间：";
    }

    public String getHello(String name) {
        return helloName + ":" + name;
    }

    public String getConfigProvider() {
        return ConfigProvider.getConfig().getValue("config-Provider.message", String.class);
    }
}
