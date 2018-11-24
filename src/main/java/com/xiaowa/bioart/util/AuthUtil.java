package com.xiaowa.bioart.util;

import javax.servlet.http.HttpSession;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hsdev-04 on 2017-11-10.
 */
public class AuthUtil {

    public static Map<String, Object> judgerole(String role, Map<String, Object> returnd, HttpSession session) {
        String currentrole = (String) session.getAttribute("role");
        Map<String, Object> errorreturnd = new HashMap();
        errorreturnd.put("error", "Ȩ�޲���");
        if (currentrole.indexOf(role) > -1) {
            return returnd;
        }
        return errorreturnd;

    }

    public static boolean haveAnnotation(Object clazz, Annotation myannotation) {
        Class claz = clazz.getClass();
        Annotation[] annotations = claz.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {  //����ѭ��
            if (annotations[i].hashCode() == myannotation.hashCode()) { //�ù�ϣ���ж�
                return true;
            }

        }
        return false;

    }
}
