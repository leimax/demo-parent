package com.accelerator.demo.ssm.web.controller;

import com.accelerator.demo.ssm.model.po.User;
import com.accelerator.demo.ssm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller @RequestMapping("guest")
public class GuestController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserService userService;

    @RequestMapping("index")
    public void index() {
        logger.info("GuestController.index method");
    }

    @RequestMapping("addUser")
    public @ResponseBody boolean addUser(User user) {
        return userService.add(user);
    }

    @RequestMapping("getUser")
    public @ResponseBody User getUser(Integer userId) {
        return userService.get(userId);
    }

    @RequestMapping("getAllUser")
    public @ResponseBody List<User> getAllUser() {
        return userService.getAll();
    }

    @RequestMapping("removeUser")
    public @ResponseBody boolean removeUser(Integer userId) {
        return userService.remove(userId);
    }

}
