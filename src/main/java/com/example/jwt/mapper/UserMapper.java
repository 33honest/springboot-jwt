package com.example.jwt.mapper;

import com.example.jwt.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Nathan.Liu on 2020/6/10.
 */
@Mapper
public interface UserMapper {

    UserModel findUserById(@Param(value = "id") Integer id);

    UserModel loadUserByUsername(@Param(value = "username") String username);

}
