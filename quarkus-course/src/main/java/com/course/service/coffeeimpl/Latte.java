package com.course.service.coffeeimpl;

import com.course.service.Coffee;
import io.quarkus.arc.Priority;
import io.quarkus.logging.Log;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

/**
 * @program: QuarkusLearn
 * @className: Lattee
 * @description: 装饰类要用注解Decorator修饰，被装饰类要用注解Delegate修饰
 * @author:
 * @create: 2022-12-16 11:18
 * @Version 1.0
 **/

@Decorator
@Priority(9)
public class Latte implements Coffee {

    private static final int MILK_PRICE = 2;

    @Delegate
    @Inject
    Coffee delegate;

    @Override
    public String name() {
        return "Latte";
    }

    @Override
    public int getPrice() {
        // 将Latte的代理类打印出来，看quarkus注入的是否正确
        Log.info("Latte's delegate type : " + this.delegate.name());
        return delegate.getPrice() + MILK_PRICE;
    }
}
