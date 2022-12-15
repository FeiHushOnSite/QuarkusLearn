package com.course.event;

import com.course.event.intonnation.Admin;
import com.course.event.intonnation.Normal;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 * @program: QuarkusLearn
 * @className: MultiChannelWithMultiEvent
 * @description:
 * @author:
 * @create: 2022-12-14 14:35
 * @Version 1.0
 **/
@ApplicationScoped
public class MultiChannelWithMultiEvent {

    @Inject
    @Admin
    Event<ProjectEvent> adminEvent;

    @Inject
    @Normal
    Event<ProjectEvent> normalEvent;

    /**
     * 管理员消息
     * @param source 消息源
     * @return 计数
     */
    public int produceAdmin(String source) {
        ProjectEvent projectEvent = new ProjectEvent(source);
        adminEvent.fire(projectEvent);
        return projectEvent.getNum();
    }

    /**
     * 普通消息
     * @param source 消息源
     * @return 计数
     */
    public int produceNormal(String source) {
        ProjectEvent projectEvent = new ProjectEvent(source);
        normalEvent.fire(projectEvent);
        return projectEvent.getNum();
    }
}
