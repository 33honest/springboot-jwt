package com.example.jwt.controller;

import com.example.jwt.vo.JSONResult;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Nathan.Liu on 2020/5/11.
 */
@RestController
public class IndexController {

    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String index() {
        return JSONResult.build("0000", "OK", "JWT");
    }

    @RequestMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String hello() {
        return JSONResult.build("0000", "OK", "Hello");
    }

    @RequestMapping(value = "/world", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String world() {

        return com.example.jwt.utils.JSONResult.fillResultString(200, "", Arrays.asList("hello"));
    }

}
