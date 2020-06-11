package com.example.jwt.service;

import com.example.jwt.security.TokenAuthenticationService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Nathan.Liu on 2020/6/11.
 */

public class UserServiceTest {

    public static void main(String[] args) {
        /*
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pwd = encoder.encode("123456");
        System.out.println(pwd);

        System.out.println(encoder.matches("123456", pwd));
        */

        String token = "eyJhbGciOiJIUzUxMiJ9.eyJhdXRob3JpdGllcyI6IlJPTEVfQURNSU4sQVVUSF9XUklURSIsInN1YiI6IjEiLCJleHAiOjE1OTE4NTk2MDZ9.r0koOzj9Tu9NM7ciYjcSHjO6A1BFJ7txui1IloXir1r8cX3M1yXb3a9XZWsQKCSoiVvyP-3K1uQCyDelhjiNeg";
        TokenAuthenticationService.getPricipal(token);



    }

}
