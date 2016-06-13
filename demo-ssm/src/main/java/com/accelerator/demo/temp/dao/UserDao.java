package com.accelerator.demo.temp.dao;


import java.util.List;

import com.accelerator.demo.temp.model.po.User;

public interface UserDao {

    int save(User user);

    User find(int id);

    List<User> findAll();

    int delete(int id);

}
