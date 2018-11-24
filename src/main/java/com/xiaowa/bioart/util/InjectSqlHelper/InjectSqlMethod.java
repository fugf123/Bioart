package com.xiaowa.bioart.util.InjectSqlHelper;

import java.util.HashMap;

/**
 * Created by hsdev-04 on 2018-03-22.
 */
public class InjectSqlMethod {
    protected static final ThreadLocal<HashMap> LOCAL_PARAM = new ThreadLocal();

    protected static void setLocalParam(HashMap localparam) {
        LOCAL_PARAM.set(localparam);
    }

    public static <T> HashMap getLocalParam() {
        return (HashMap) LOCAL_PARAM.get();
    }

    public static void clearParam() {
        LOCAL_PARAM.remove();
    }

    public static void startInjectSql(HashMap localparam) {
        setLocalParam(localparam);
    }

}
