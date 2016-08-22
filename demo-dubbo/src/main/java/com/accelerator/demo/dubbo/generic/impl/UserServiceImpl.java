package com.accelerator.demo.dubbo.generic.impl;

import com.accelerator.demo.dubbo.generic.api.IUserService;

public class UserServiceImpl implements IUserService {

    public User get(Params params) {
        return new User(1, "charles");
    }

}
