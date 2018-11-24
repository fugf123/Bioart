package com.xiaowa.bioart.common;

import com.alibaba.fastjson.JSONObject;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by hsdev-04 on 2017-02-06.
 */
public class ErrorService {
    public static JSONObject webSvcError(String errcode, String errmessage, String errdetail) {
        JSONObject websvcerror = new JSONObject();
        websvcerror.put("errCode", errcode);
        websvcerror.put("errMessage", errmessage);
        websvcerror.put("errDetail", errdetail);
        return websvcerror;
    }


    public static JSONObject superSvcError(String errcode, String errmessage, String errdetail) {
        JSONObject superSvc = new JSONObject();
        JSONObject websvcerror = new JSONObject();
        websvcerror.put("errCode", errcode);
        websvcerror.put("errMessage", errmessage);
        websvcerror.put("errDetail", errdetail);
        superSvc.put("webSvcError", websvcerror);
        return superSvc;
    }

    public static JSONObject autoSvcError(String errcode, String errmessage, Exception e) {
        JSONObject superSvc = new JSONObject();
        JSONObject websvcerror = new JSONObject();
        websvcerror.put("errCode", errcode);
        websvcerror.put("errMessage", errmessage);
        websvcerror.put("errDetail", getErrorInfoFromException(e));
        superSvc.put("webSvcError", websvcerror);
        return superSvc;
    }

    public static String getErrorInfoFromException(Exception e) {
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            return "\r\n" + sw.toString() + "\r\n";
        } catch (Exception e2) {
            return "bad getErrorInfoFromException";
        }
    }
}
