package com.accelerator.demo.ssm.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accelerator.demo.ssm.model.po.User;
import com.accelerator.demo.ssm.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@Controller("guest")
public class GuestController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserService userService;

    @RequestMapping("index")
    public void index() throws Exception {
        logger.info("GuestController.index method");
    }

    @ResponseBody
    @RequestMapping("addUser")
    public boolean addUser(User user) {
        return userService.add(user);
    }

    @ResponseBody
    @RequestMapping("getUser")
    public User getUser(Integer userId) {
        return userService.get(userId);
    }

    @ResponseBody
    @RequestMapping("getAllUser")
    public List<User> getAllUser() {
        return userService.getAll();
    }

    @ResponseBody
    @RequestMapping("removeUser")
    public boolean removeUser(Integer userId) {
        return userService.remove(userId);
    }

}
