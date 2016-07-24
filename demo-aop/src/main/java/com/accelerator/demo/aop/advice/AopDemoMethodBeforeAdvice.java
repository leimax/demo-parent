package com.accelerator.demo.aop.advice;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;


public class AopDemoMethodBeforeAdvice extends MethodBeforeAdviceInterceptor {

    public AopDemoMethodBeforeAdvice(MethodBeforeAdvice advice) {
        super(advice);
    }

}
