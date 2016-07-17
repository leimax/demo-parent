package com.accelerator.demo.aop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AopDemoService {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public String doSomething() {
        logger.info("doSomething()正被调用！！");
        return "returnStr";
    }

}
