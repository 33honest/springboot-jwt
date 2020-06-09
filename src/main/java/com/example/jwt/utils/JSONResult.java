package com.example.jwt.utils;

import org.json.JSONObject;

/**
 * Created by Nathan.Liu on 2020/6/9.
 */
public class JSONResult {

    public static String fillResultString(Integer status, String message, Object result) {
        JSONObject jsonObject = new JSONObject() {{
            put("status", status);
            put("message", message);
            put("result", result);
        }};
        return jsonObject.toString();
    }

}
