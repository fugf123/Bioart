package com.xiaowa.bioart.util;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hstech-dev10
 * @Date: Created in 2018-01-29
 * @Modified By:
 */
public class ALiOutJson {

    public static JSONObject success(String msg) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", true);
        jsonObject.put("msg", msg);
        jsonObject.put("code", 200);
        return jsonObject;
    }

    public static JSONObject success(String msg, List<?> data) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", true);
        jsonObject.put("msg", msg);
        jsonObject.put("code", 200);
        jsonObject.put("data", data == null ? new ArrayList() : data);
        return jsonObject;
    }

    public static JSONObject success(String msg, JSONObject object) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", true);
        jsonObject.put("msg", msg);
        jsonObject.put("code", 200);
        jsonObject.put("data", object);
        return jsonObject;
    }

    public static JSONObject success(String msg, String data) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", true);
        jsonObject.put("msg", msg);
        jsonObject.put("code", 200);
        jsonObject.put("data", data);
        return jsonObject;
    }

    public static JSONObject success(String msg, Object object) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", true);
        jsonObject.put("msg", msg);
        jsonObject.put("code", 200);
        jsonObject.put("data", object);
        return jsonObject;
    }

    /**
     * ∑µªÿ ß∞‹
     */
    public static JSONObject failure(String msg) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", false);
        jsonObject.put("msg", msg);
        jsonObject.put("code", 400);
        return jsonObject;
    }

    public static JSONObject failure(String msg, String data) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", false);
        jsonObject.put("code", 400);
        jsonObject.put("data", data);
        jsonObject.put("msg", msg);
        return jsonObject;
    }

    public static JSONObject failure(String msg, List<?> data) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", false);
        jsonObject.put("msg", msg);
        jsonObject.put("code", 400);
        jsonObject.put("data", data == null ? new ArrayList() : data);
        return jsonObject;
    }

    public static JSONObject failure(String msg, Object object) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", false);
        jsonObject.put("msg", msg);
        jsonObject.put("code", 400);
        jsonObject.put("data", object);
        return jsonObject;
    }
}
