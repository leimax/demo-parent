package com.accelerator.demo.temp.service.impl;

import org.springframework.stereotype.Service;

import com.accelerator.demo.temp.dao.UserDao;
import com.accelerator.demo.temp.model.po.User;
import com.accelerator.demo.temp.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public boolean add(User user) {
        int rows = userDao.save(user);
        return rows > 0;
    }

    @Override
    public User get(Integer id) {
        return userDao.find(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    public boolean remove(Integer id) {
        int rows = userDao.delete(id);
        return rows > 0;
    }


}
