package com.accelerator.demo.aop;

import com.accelerator.demo.aop.service.AopDemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainRunner {

    private static final ClassPathXmlApplicationContext CONTEXT = new ClassPathXmlApplicationContext("applicationContext.xml");

    public static void main(String[] args) {
        AopDemoService aopDemoService = CONTEXT.getBean("aopDemoService", AopDemoService.class);
        aopDemoService.doSomething();
    }

}
