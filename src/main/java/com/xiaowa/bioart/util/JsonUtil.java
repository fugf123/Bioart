package com.xiaowa.bioart.util;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hsdev-04 on 2017-02-06.
 */
public class JsonUtil {
    public static <T> HashMap parseMap(String params, Class<T> clazz) {
        T obj = JSON.parseObject(params, clazz);
        HashMap parse = JSON.parseObject(JSON.toJSONString(obj), HashMap.class);
        return parse;
    }

    public static <T> T parseObject(Map map, Class<T> clazz) {
        String json = JSON.toJSONString(map);
        T obj = JSON.parseObject(json, clazz);
        return obj;
    }
}
