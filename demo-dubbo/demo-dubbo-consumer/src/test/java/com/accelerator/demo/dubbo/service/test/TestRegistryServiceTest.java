package com.accelerator.demo.dubbo.service.test;

import com.accelerator.demo.dubbo.service.TestRegistryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestRegistryServiceTest {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private TestRegistryService testRegistryService;

    @Test
    public void get() throws Exception {
        Map<String, String> test = testRegistryService.get("test");
        logger.info(test.toString());
    }

}