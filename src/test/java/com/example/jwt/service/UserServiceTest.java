package com.example.jwt.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Nathan.Liu on 2020/6/11.
 */

public class UserServiceTest {

    public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pwd = encoder.encode("123456");
        System.out.println(pwd);

        System.out.println(encoder.matches("123456", pwd));

    }

}
