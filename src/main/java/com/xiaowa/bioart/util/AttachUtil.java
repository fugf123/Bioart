package com.xiaowa.bioart.util;

import com.xiaowa.bioart.result.Config;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Map;

/**
 * Created by hsdev-04 on 2017-11-13.
 */
public class AttachUtil {
    public static int deleteAttach(HttpSession session, Map<String, Object> map) {
        String uid = (String) session.getAttribute("uid");
        String attach_fn = map.get("attach_fn").toString();
        String ext = map.get("ext_name").toString();
        //��ȡ�����ļ��еĸ�·��
        String rootUrl = ResourcesUtil.getValue(Config.SYSTEMCONFIG, uid);
        //ƴ������·��
        StringBuilder buffer = new StringBuilder(rootUrl);
        buffer.append(attach_fn.substring(0, 4)).append("-");
        buffer.append(attach_fn.substring(4, 6)).append("/");
        buffer.append(attach_fn.substring(6, 8)).append("/");

        File oldFile = new File(buffer.toString(), attach_fn + ext);
        File oidFile_zip = new File(buffer.toString(), attach_fn + "_zip" + ext);
        if (oldFile.exists()) {
            oldFile.delete();
        }
        if (oidFile_zip.exists()) {
            oidFile_zip.delete();
        }
        return 1;

    }
}
