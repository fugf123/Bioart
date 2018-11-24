package com.xiaowa.bioart.util;

/**
 * Created by hsdev-08 on 2018-01-19.
 */
public class PicUtil {

    public static boolean isPicture(String fileName) {
        // 获取文件后缀名并转化为写，用于后续比较
        String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()).toLowerCase();
        // 创建图片类型数组
        String img[] = {"bmp", "jpg", "jpeg", "png", "tiff", "gif", "pcx", "tga", "exif", "fpx", "svg", "psd",
                "cdr", "pcd", "dxf", "ufo", "eps", "ai", "raw", "wmf"};
        for (int i = 0; i < img.length; i++) {
            if (img[i].equals(fileType)) {
                return true;
            }
        }
        return false;
    }
}
