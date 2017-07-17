package com.accelerator.demo.redis.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class RedisTemplateTest {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void set() {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("a", "a");
    }

    @Test
    public void get() {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        logger.info("value:{}", valueOperations.get("a"));
    }


    @Test
    public void del() {
        redisTemplate.delete("a");
    }
}
