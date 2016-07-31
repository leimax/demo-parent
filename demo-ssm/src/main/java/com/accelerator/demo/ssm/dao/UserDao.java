package com.accelerator.demo.ssm.dao;


import java.util.List;

import com.accelerator.demo.ssm.model.po.User;

public interface UserDao {

    int save(User user);

    User find(int id);

    List<User> findAll();

    int delete(int id);

}
