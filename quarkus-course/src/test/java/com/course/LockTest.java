package com.course;

import com.course.service.AccountBalanceService;
import io.quarkus.logging.Log;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.concurrent.CountDownLatch;

/**
 * @program: QuarkusLearn
 * @className: LockTest
 * @description: 多线程同步的5种解决方式
 * 1.传统的synchronized关键字修饰三个方法
 * 2.java的读写锁
 * 3.deposit和deduct方法内部，不要使用临时变量tempValue,将余额的类型从int改成AtomicInteger,再使用addAndGet方法计算并设置
 * 4.用mysql的乐观锁
 * 5.用Redis分布式锁
 *
 * =>>>>>>>>新方法called bean 读写锁
 * @author:
 * @create: 2022-12-16 14:33
 * @Version 1.0
 **/
@QuarkusTest
public class LockTest {

    @Inject
    AccountBalanceService account;

    @Test
    public void test() throws InterruptedException{
        CountDownLatch latch = new CountDownLatch(3);

        int initValue = account.get();

        final int COUNT = 10;

        //这是个只负责读取的线程，循环读10次，每读一次就等待50毫秒
        new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                 // 读取账号余额
                Log.infov("current balance {0}", account.get());
            }
            latch.countDown();;
        }).start();

        new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                account.deposit(2);
            }
            latch.countDown();;
        }).start();

        new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                account.deduct(1);
            }
            latch.countDown();;
        }).start();

        latch.await();

        int finalValue = account.get();
        Log.infov("finally current balance {0}", finalValue);
        Assertions.assertEquals(initValue + COUNT, finalValue);
    }
}
