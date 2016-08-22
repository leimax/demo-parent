package com.accelerator.demo.dubbo.aop.action;

import com.accelerator.demo.dubbo.aop.api.AopService;

public class AopAction {

    private AopService aopService;

    public String doSayHello(String name) {
        return aopService.sayHello(name);
    }

    public void setAopService(AopService aopService) {
        this.aopService = aopService;
    }
}
