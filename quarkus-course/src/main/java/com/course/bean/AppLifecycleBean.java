package com.course.bean;


import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.event.Observes;
import javax.inject.Inject;


/**
 * @program: QuarkusLearn
 * @className: AppLifecycleBean
 * @description:
 * @author:
 * @create: 2022-12-13 14:55
 * @Version 1.0
 **/
public class AppLifecycleBean {

    private static final Logger LOGGER = LoggerFactory.getLogger("ListenerBean");

    @Inject
    AppRuntimeStatusBean bean;

    void onStart(@Observes StartupEvent ev) {
        LOGGER.info("The application is starting...{}", bean.startupStatus());
    }

    void onStop(@Observes ShutdownEvent ev) {
        LOGGER.info("The application is stopping....{}", bean.terminationStatus());
    }
}
