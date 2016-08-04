package com.accelerator.demo.ssm.dao.impl;

import com.accelerator.demo.ssm.dao.UserDao;
import com.accelerator.demo.ssm.dao.mapper.UserMapper;
import com.accelerator.demo.ssm.model.po.User;
import org.springframework.stereotype.Repository;

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
