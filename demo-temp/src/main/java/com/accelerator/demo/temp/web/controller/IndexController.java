package com.accelerator.demo.temp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.Map;

@Controller
public class IndexController {

    @RequestMapping(value = "index", method = RequestMethod.POST)
    public @ResponseBody Map<?, ?> index(Model model) {
        return Collections.singletonMap("state", "SUCCESS");
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public void index() {}



}
