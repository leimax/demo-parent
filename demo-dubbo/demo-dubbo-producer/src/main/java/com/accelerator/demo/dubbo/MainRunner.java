package com.accelerator.demo.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Accelerator on 2016/8/15.
 */
public class MainRunner {

    private static final ClassPathXmlApplicationContext CONTEXT = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

    public static void main(String[] args) throws InterruptedException {
        CONTEXT.start();
        Thread.sleep(Long.MAX_VALUE);
    }

}
