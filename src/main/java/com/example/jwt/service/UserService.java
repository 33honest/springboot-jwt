package com.example.jwt.service;

import com.example.jwt.mapper.UserMapper;
import com.example.jwt.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Nathan.Liu on 2020/6/10.
 */
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserModel findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    @Override
    public UserModel loadUserByUsername(String username) {
        System.out.println("loadUserByUsername 方法");
        return userMapper.loadUserByUsername(username);
    }
}
