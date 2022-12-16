package com.course.service.coffeeimpl;

import com.course.service.Coffee;

import javax.enterprise.context.ApplicationScoped;

/**
 * @program: QuarkusLearn
 * @className: Espresso
 * @description:
 * @author:
 * @create: 2022-12-16 11:32
 * @Version 1.0
 **/
@ApplicationScoped
public class Espresso implements Coffee {

    @Override
    public String name() {
        return "Espresso";
    }

    @Override
    public int getPrice() {
        return 3;
    }
}
