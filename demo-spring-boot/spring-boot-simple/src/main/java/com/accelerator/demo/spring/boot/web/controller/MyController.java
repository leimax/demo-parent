package com.accelerator.demo.spring.boot.web.controller;

import com.accelerator.demo.spring.boot.model.MyThing;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/thing")
    public MyThing thing() {
        return new MyThing();
    }

}
