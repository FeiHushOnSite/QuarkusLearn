package com.course;

import com.course.service.Coffee;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

/**
 * @program: QuarkusLearn
 * @className: DecoratorTest
 * @description:
 * @author:
 * @create: 2022-12-16 11:27
 * @Version 1.0
 **/
@QuarkusTest
public class DecoratorTest {

    @Inject
    Coffee coffee;

    @Test
    public void testDecoratorPrice() {
        Assertions.assertEquals(6, coffee.getPrice());
    }
}
