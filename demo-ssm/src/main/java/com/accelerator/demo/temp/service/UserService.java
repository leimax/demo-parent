package com.accelerator.demo.temp.service;


import java.util.List;

import com.accelerator.demo.temp.model.po.User;

public interface UserService {

    boolean add(User user);

    User get(Integer id);

    List<User> getAll();

    boolean remove(Integer id);

}
