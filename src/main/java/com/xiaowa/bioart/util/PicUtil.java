package com.xiaowa.bioart.util;

/**
 * Created by hsdev-08 on 2018-01-19.
 */
public class PicUtil {

    public static boolean isPicture(String fileName) {
        // ��ȡ�ļ���׺����ת��Ϊд�����ں����Ƚ�
        String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()).toLowerCase();
        // ����ͼƬ��������
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
