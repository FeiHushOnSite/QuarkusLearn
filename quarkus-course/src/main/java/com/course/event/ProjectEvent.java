package com.course.event;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: QuarkusLearn
 * @className: Event
 * @description:
 * @author:
 * @create: 2022-12-14 13:33
 * @Version 1.0
 **/
public class ProjectEvent {

    /**
     * 事件薄
     */
    private String source;

    /**
     * 事件被消费的总次数
     */
    private AtomicInteger consumeNum;

    public ProjectEvent(String source) {
        this.source = source;
        consumeNum = new AtomicInteger();
    }

    /**
     * 事件被消费次数加一
     * @return
     */
    public int addNum() {
        return consumeNum.incrementAndGet();
    }

    /**
     * 获取事件被消费次数
     * @return
     */
    public int getNum() {
        return consumeNum.get();
    }

    @Override
    public String toString() {
        return "Event{" +
                "source='" + source + '\'' +
                ", consumeNum=" + getNum() +
                '}';
    }
}
