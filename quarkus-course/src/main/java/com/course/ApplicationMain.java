package com.course;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

/**
 * @program: QuarkusLearn
 * @className: ApplicationMain
 * @description:
 * @author:
 * @create: 2022-12-13 14:42
 * @Version 1.0
 **/
@QuarkusMain
public class ApplicationMain implements QuarkusApplication {

    public static void main(String... args) {
        Quarkus.run(ApplicationMain.class, args);
    }

    @Override
    public int run(String... args) throws Exception {
        if(args.length > 0) {
            System.out.println("hi, command mode, this is args:" + args);
        } else {
            System.out.println("hi, command mode");
        }

        Quarkus.waitForExit();
        return 0;
    }
}
