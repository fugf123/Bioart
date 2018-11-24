package com.xiaowa.bioart.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dzy on 17-2-12.
 */
public class RegexUtil {
    /**
     * ��ȡ��ѯ���ַ���
     * ��ƥ����ַ���ȡ��
     */
    public static String getString(String str, String regx) {
        String returnd = null;
        //1.�����ڱ��ʽ��װ�ɶ���Patten ����ʵ��
        Pattern pattern = Pattern.compile(regx);
        //2.���ַ�����������ʽ�����
        Matcher matcher = pattern.matcher(str);
        //3.String �����е�matches ��������ͨ�����Matcher��pattern��ʵ�ֵġ�
        //���ҷ��Ϲ�����Ӵ�
        while (matcher.find()) {
            returnd = matcher.group();
          /*  //��ȡ �ַ���

            //��ȡ���ַ�������λ�ú�ĩλ��
            */

        }
        return returnd;
    }

    /******
     *author:hsdev-04
     *date:2017-03-03 16:23
     *note:��ȡ��ƥ��ĵ�index���ַ���
     ******/
    public static String getString(String str, String regx, int index) {
        String returnd = null;
        //1.�����ڱ��ʽ��װ�ɶ���Patten ����ʵ��
        Pattern pattern = Pattern.compile(regx);
        //2.���ַ�����������ʽ�����
        Matcher matcher = pattern.matcher(str);
        //3.String �����е�matches ��������ͨ�����Matcher��pattern��ʵ�ֵġ�
        //���ҷ��Ϲ�����Ӵ�
        while (matcher.find()) {
            returnd = matcher.group(index);
          /*  //��ȡ �ַ���

            //��ȡ���ַ�������λ�ú�ĩλ��
            */

        }
        return returnd;
    }

}
