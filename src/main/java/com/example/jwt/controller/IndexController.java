package com.example.jwt.controller;

import com.example.jwt.security.TokenAuthenticationService;
import com.example.jwt.vo.JSONResult;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
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

    @RequestMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello() {
        return JSONResult.build("0000", "OK", "Hello");
    }

    @RequestMapping(value = "/world", produces = MediaType.APPLICATION_JSON_VALUE)
    public String world() {

        return com.example.jwt.utils.JSONResult.fillResultString(200, "", Arrays.asList("hello"));
    }

    @RequestMapping(value = "/token", produces = MediaType.APPLICATION_JSON_VALUE)
    public String token(HttpServletRequest request) {
        String result = "";
        try {
            String content = FileCopyUtils.copyToString(new InputStreamReader(request.getInputStream(), Charset.forName("UTF-8")));
            result = TokenAuthenticationService.getPricipal(content);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return com.example.jwt.utils.JSONResult.fillResultString(200, "", result);
    }

}
