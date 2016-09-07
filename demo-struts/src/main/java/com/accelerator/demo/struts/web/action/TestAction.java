package com.accelerator.demo.struts.web.action;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("testAction") @Scope("prototype")
public class TestAction extends ActionSupport {

    private static final long serialVersionUID = 9059659138232278386L;

    public String test() {
        return SUCCESS;
    }

}
