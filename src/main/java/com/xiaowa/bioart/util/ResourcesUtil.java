package com.xiaowa.bioart.util;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.*;

/**
 * ��Դ�ļ���ȡ������
 */
public class ResourcesUtil implements Serializable {

    private static final long serialVersionUID = -7657898714983901418L;

    /**
     * ϵͳ���Ի�����Ĭ��Ϊ����zh
     */
    public static final String LANGUAGE = "zh";

    /**
     * ϵͳ���һ�����Ĭ��Ϊ�й�CN
     */
    public static final String COUNTRY = "CN";

    private static Locale getLocale() {
        Locale locale = new Locale(LANGUAGE, COUNTRY);
        return locale;
    }

    /**
     * �������ԡ����ҡ���Դ�ļ�����key���ֻ�ȡ��Դ�ļ�ֵ
     *
     * @param //language ����
     * @param //country  ����
     * @param baseName   ��Դ�ļ���
     * @param section    key����
     * @return ?
     */
    private static String getProperties(String baseName, String section) {
        String retValue = "";
        try {
            Locale locale = getLocale();
            ResourceBundle rb = ResourceBundle.getBundle(baseName, locale);
            retValue = (String) rb.getObject(section);
            retValue = new String(retValue.getBytes("ISO-8859-1"), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            // TODO ��Ӵ���
        }
        return retValue;
    }

    /**
     * ͨ��key����Դ�ļ���ȡ����
     *
     * @param fileName ��Դ�ļ���
     * @param key      ����
     * @return ������Ӧ������
     */
    public static String getValue(String fileName, String key) {
        String value = getProperties(fileName, key);
        return value;
    }

    public static List<String> gekeyList(String baseName) {
        Locale locale = getLocale();
        ResourceBundle rb = ResourceBundle.getBundle(baseName, locale);

        List<String> reslist = new ArrayList<String>();

        Set<String> keyset = rb.keySet();
        for (Iterator<String> it = keyset.iterator(); it.hasNext(); ) {
            String lkey = (String) it.next();
            reslist.add(lkey);
        }

        return reslist;

    }

    /**
     * ͨ��key����Դ�ļ���ȡ���ݣ�����ʽ��
     *
     * @param fileName ��Դ�ļ���
     * @param key      ����
     * @param objs     ��ʽ������
     * @return ��ʽ���������
     */
    public static String getValue(String fileName, String key, Object[] objs) {
        String pattern = getValue(fileName, key);
        String value = MessageFormat.format(pattern, objs);
        return value;
    }

    public static void main(String[] args) {


        //���ݲ���ϵͳ������ȡ���Ի���
		/*Locale locale = Locale.getDefault();
		//������Ҵ���
		//������Դ���s

		//���ع��ʻ���Դ��classpath��resourcesĿ¼�µ�messages.properties����������Ļ�����������messages_zh_CN.properties��
		ResourceBundle rb = ResourceBundle.getBundle("resources.messages", locale);
		String retValue = rb.getString("101");//101��messages.properties�ļ��е�key
		System.out.println(retValue);

		//��Ϣ��ʽ���������Դ����{}�Ĳ�������Ҫʹ��MessageFormat��ʽ����Object[]Ϊ���ݵĲ���������������Դ�ļ��е�{}��������
		String value = MessageFormat.format(retValue, new Object[]{100,200});
		System.out.println(value);
*/

    }
}
