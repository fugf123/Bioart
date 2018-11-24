package com.xiaowa.bioart.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hsdev-04 on 2017-07-24.
 */
public class GenerateCode {

    public static String code18(String pre) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String strdate = simpleDateFormat.format(date);
        return pre + strdate + Math.random() * 1000;
    }


}
