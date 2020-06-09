package com.example.jwt.vo;

import org.json.JSONObject;

/**
 * Created by Nathan.Liu on 2020/5/11.
 */
public class JSONResult {

    public static String build(String statusCode, String msg, Object result) {
        JSONObject obj = new JSONObject() {{
            put("statusCode", statusCode);
            put("msg", msg);
            put("result", result);
        }};
        return obj.toString();
    }

}
