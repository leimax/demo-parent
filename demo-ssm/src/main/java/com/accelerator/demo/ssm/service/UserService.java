package com.accelerator.demo.ssm.service;


import com.accelerator.demo.ssm.model.po.User;

import java.util.List;

public interface UserService {

    boolean add(User user);

    User get(Integer id);

    List<User> getAll();

    boolean remove(Integer id);

}
