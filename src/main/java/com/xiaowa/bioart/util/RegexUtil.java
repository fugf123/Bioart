package com.xiaowa.bioart.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dzy on 17-2-12.
 */
public class RegexUtil {
    /**
     * 获取查询的字符串
     * 将匹配的字符串取出
     */
    public static String getString(String str, String regx) {
        String returnd = null;
        //1.将正在表达式封装成对象Patten 类来实现
        Pattern pattern = Pattern.compile(regx);
        //2.将字符串和正则表达式相关联
        Matcher matcher = pattern.matcher(str);
        //3.String 对象中的matches 方法就是通过这个Matcher和pattern来实现的。
        //查找符合规则的子串
        while (matcher.find()) {
            returnd = matcher.group();
          /*  //获取 字符串

            //获取的字符串的首位置和末位置
            */

        }
        return returnd;
    }

    /******
     *author:hsdev-04
     *date:2017-03-03 16:23
     *note:获取所匹配的第index个字符串
     ******/
    public static String getString(String str, String regx, int index) {
        String returnd = null;
        //1.将正在表达式封装成对象Patten 类来实现
        Pattern pattern = Pattern.compile(regx);
        //2.将字符串和正则表达式相关联
        Matcher matcher = pattern.matcher(str);
        //3.String 对象中的matches 方法就是通过这个Matcher和pattern来实现的。
        //查找符合规则的子串
        while (matcher.find()) {
            returnd = matcher.group(index);
          /*  //获取 字符串

            //获取的字符串的首位置和末位置
            */

        }
        return returnd;
    }

}
