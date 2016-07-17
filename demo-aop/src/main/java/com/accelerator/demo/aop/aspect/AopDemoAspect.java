package com.accelerator.demo.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopDemoAspect {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut(value = "execution(* com.accelerator.demo.aop.service.AopDemoService.doSomething(..))")
    public void pointcut() {
    }

    @Before(value = "pointcut()")
    public void before(JoinPoint point) {
        logger.info("Aspect Before 被调用！");
    }

    @After(value = "pointcut()")
    public void after(JoinPoint point) {
        logger.info("Aspect After 被调用！");
    }

    @Around(value = "pointcut()")
    public void around(ProceedingJoinPoint point) throws Throwable {
        logger.info("Aspect Around 调用开始！");
        Object result = point.proceed();
        logger.info("Around调用返回值：{}", result);
        logger.info("Aspect Around 调用结束！");
    }

    @AfterReturning(value = "pointcut()", returning = "returnObj")
    public void afterReturning(JoinPoint point, String returnObj) {
        logger.info("AfterReturning 被调用！");
        logger.info("AfterReturning调用返回值：{}", returnObj);
    }

}
