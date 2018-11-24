package com.xiaowa.bioart.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hsdev-08 on 2017-03-30.
 */
public class JSON2MapUtil {

    public static Map<String, Object> parseJSON2Map(String jsonStr) {
        Map<String, Object> map = new HashMap<String, Object>();
        //最外层解析
        JSONObject json = JSONObject.parseObject(jsonStr);
        for (Object k : json.keySet()) {
            Object v = json.get(k);
//            如果内层还是数组的话，继续解析
            if (v instanceof JSONObject) {
//                List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//                Iterator<Object> it = ((JSONArray) v).iterator();
//                while (it.hasNext()) {
//                    JSONObject json2 = (JSONObject) it.next();
//                    list.add(parseJSON2Map(json2.toString()));
                Map<String, Object> map2 = new HashMap<String, Object>();
                for (Object k2 : ((JSONObject) v).keySet()) {
                    Object v2 = ((JSONObject) v).get(k2);
                    map2.put(k2.toString(), v2);
                }
                v = map2;
            }
            map.put(k.toString(), v);
//            }
        }
        return map;
    }

    public static List<String> JSONArray2List(String jsonString) {
        JSONArray jsonArray = JSONArray.parseArray(jsonString);
        List<String> list = new ArrayList<String>();
        for (Object str : jsonArray) {
            list.add((String) str);
        }
        return list;
    }
}
