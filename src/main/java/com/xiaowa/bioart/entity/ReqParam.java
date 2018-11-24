package com.xiaowa.bioart.entity;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by hsdev-04 on 2017-02-04.
 */
public class ReqParam {
    private String serviceName = null;
    private String portName = null;
    private String uId = null;
    private JSONArray reqInfo = null;
    private JSONObject svcError = null;

    public JSONObject getSvcError() {
        return svcError;
    }

    public void setSvcError(JSONObject svcError) {
        this.svcError = svcError;
    }

    public String getServiceName() {

        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public JSONArray getReqInfo() {
        return reqInfo;
    }

    public void setReqInfo(JSONArray reqInfo) {
        this.reqInfo = reqInfo;
    }
}
