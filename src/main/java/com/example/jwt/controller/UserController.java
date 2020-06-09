package com.example.jwt.controller;

import com.example.jwt.vo.JSONResult;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by Nathan.Liu on 2020/5/11.
 */
@RestController
public class UserController {


    @RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String userList() {
        ArrayList<String> users = new ArrayList<String>() {{
            add("freewolf");
            add("tom");
            add("jerry");
        }};

        return JSONResult.build("0000", "OK", users);
    }


}
