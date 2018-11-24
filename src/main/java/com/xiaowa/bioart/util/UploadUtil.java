package com.xiaowa.bioart.util;

import com.xiaowa.bioart.result.Config;

/**
 * Created by hsdev-08 on 2017-11-15.
 */
public class UploadUtil {

    public static String create(String attach_fn, String uid) throws Exception {
        //获取配置文件中的根路径
        String rootUrl = ResourcesUtil.getValue(Config.SYSTEMCONFIG, uid);
        if (rootUrl == null || rootUrl.trim().equals("")) {
            ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 303, null));
        }
        //拼成完整路径
        StringBuilder buffer = new StringBuilder(rootUrl);
        buffer.append(attach_fn.substring(0, 4)).append("-");
        buffer.append(attach_fn.substring(4, 6)).append("/");
        buffer.append(attach_fn.substring(6, 8)).append("/");
        return buffer.toString();
    }
}
