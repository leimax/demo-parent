package com.accelerator.demo.ssm.service.impl;

import com.accelerator.demo.ssm.model.mapper.UserMapper;
import com.accelerator.demo.ssm.model.po.User;
import com.accelerator.demo.ssm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean add(User user) {
        int rows = userMapper.insert(user);
        return rows > 0;
    }

    @Override
    public User get(Integer id) {
        return userMapper.selectByPrimaryKey(id.longValue());
    }

    @Override
    public List<User> getAll() {
        return userMapper.selectAll();
    }

    @Override
    public boolean remove(Integer id) {
        int rows = userMapper.deleteByPrimaryKey(id.longValue());
        return rows > 0;
    }

}
