package com.accelerator.demo.dubbo.service.impl;

import com.accelerator.demo.dubbo.service.TestRegistryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
public class TestRegistryServiceImpl implements TestRegistryService {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Map<String, String> get(String param) {
        logger.info("param:{}", param);
        return Collections.singletonMap("param", param);
    }

}
