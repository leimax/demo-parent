package com.accelerator.demo.temp.web.controller;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    @Resource
    private DataSource dataSource;

    @RequestMapping("index")
    public @ResponseBody Map<String, Object> index(String param) {
        HashMap<String, Object> result = Maps.newHashMap();
        result.put("state", "SUCCESS");
        return result;
    }

}
