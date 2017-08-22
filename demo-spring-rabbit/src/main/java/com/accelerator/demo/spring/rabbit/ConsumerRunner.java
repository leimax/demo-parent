package com.accelerator.demo.spring.rabbit;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerRunner {

    private static final ClassPathXmlApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("applicationContext-consumer.xml");

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }

}
