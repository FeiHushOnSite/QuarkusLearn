package com.course.service;

/**
 * @program: QuarkusLearn
 * @interfaceName: Coffee
 * @description:
 * @author:
 * @create: 2022-12-16 11:14
 * @Version 1.0
 **/
public interface Coffee {

    /**
     * 咖啡名称
     * @return
     */
    String name();

    /**
     * 当前咖啡的价格
     * @return
     */
    int getPrice();
}
