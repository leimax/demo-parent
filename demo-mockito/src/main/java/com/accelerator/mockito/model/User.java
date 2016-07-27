package com.accelerator.mockito.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    private String name = "test";

    private int age = 10;

    public String getName() {
        logger.info("com.accelerator.mockito.model.User.getName() 被调用！");
        return name;
    }

    public int getAge() {
        logger.info("com.accelerator.mockito.model.User.getAge() 被调用！");
        return age;
    }
}
