package com.accelerator.demo.temp.dao.impl;

import org.springframework.stereotype.Repository;

import com.accelerator.demo.temp.dao.UserDao;
import com.accelerator.demo.temp.dao.mapper.UserMapper;
import com.accelerator.demo.temp.model.po.User;

import javax.annotation.Resource;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Resource
    private UserMapper userMapper;

    @Override
    public int save(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public User find(int id) {
        long idl = id;
        return userMapper.selectByPrimaryKey(idl);
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public int delete(int id) {
        long idl = id;
        return userMapper.deleteByPrimaryKey(idl);
    }

}