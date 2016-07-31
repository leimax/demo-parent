package com.accelerator.demo.ssm.service;


import java.util.List;

import com.accelerator.demo.ssm.model.po.User;

public interface UserService {

    boolean add(User user);

    User get(Integer id);

    List<User> getAll();

    boolean remove(Integer id);

}
