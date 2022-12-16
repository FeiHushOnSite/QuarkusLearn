package com.course.service.coffeeimpl;

import com.course.service.Coffee;
import io.quarkus.arc.Priority;
import io.quarkus.logging.Log;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

/**
 * @program: QuarkusLearn
 * @interfaceName: CaramelMacchiato
 * @description:
 * @author:
 * @create: 2022-12-16 11:24
 * @Version 1.0
 **/
@Decorator
@Priority(10)
public class CaramelMacchiato implements Coffee {

    private static final int CARAMEL_PRICE = 1;

    @Delegate
    @Inject
    Coffee delegate;

    @Override
    public String name() {
        return "CaramelMacchiato";
    }

    @Override
    public int getPrice() {
        // 将CaramelMacchiato的代理类打印出来，看quarkus注入的是否正确
        Log.infov("CaramelMacchiato's delegate type : " + this.delegate.name());
        return delegate.getPrice() + CARAMEL_PRICE;
    }
}
