package com.example.jwt.service;

import com.example.jwt.model.UserModel;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by Nathan.Liu on 2020/6/10.
 */
public interface IUserService extends UserDetailsService {

    UserModel findUserById(Integer id);

}
