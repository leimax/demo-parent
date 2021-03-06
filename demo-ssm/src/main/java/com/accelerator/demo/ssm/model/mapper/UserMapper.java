package com.accelerator.demo.ssm.model.mapper;

import com.accelerator.demo.ssm.model.po.User;

import java.util.List;

public interface UserMapper {

    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectAll();
}