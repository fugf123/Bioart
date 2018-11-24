package com.xiaowa.bioart.result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ϵͳ��ʾ��Ϣ��װ��
 *
 * @author mrt
 */
public class ResultInfo {
    public static final int TYPE_RESULT_FAIL = 0;//ʧ��
    public static final int TYPE_RESULT_SUCCESS = 1;//�ɹ�
    public static final int TYPE_RESULT_WARN = 2;//����
    public static final int TYPE_RESULT_INFO = 3;//��ʾ��Ϣ

    public ResultInfo() {
    }

    /**
     * ��Ϣ��ʾ����
     */
    private int type;


    /**
     * ��ʾ����
     */
    private int messageCode;


    /**
     * ��ʾ��Ϣ
     */
    private String message;


    /**
     * ��ʾ��Ϣ��ϸ�б�
     */
    private List<ResultInfo> details;

    public List<ResultInfo> getDetails() {
        return details;
    }


    public void setDetails(List<ResultInfo> details) {
        this.details = details;
    }

    /**
     * ��ʾ��Ϣ��Ӧ��������ţ������û��������⣬ͨ��������������ʾ��Ϣ�б�ʶ��¼���
     */
    private int index;


    /**
     * �ύ��õ���ҵ��������Ϣ�Ӷ����ظ�ҳ��
     */
    private Map<String, Object> sysdata = new HashMap<String, Object>();

    /**
     * ���캯��,�����ύ��Ϣ����messageCode��ȡ��ʾ��Ϣ
     *
     * @param
     */
    public ResultInfo(final int type, int messageCode, String message) {
        this.type = type;
        this.messageCode = messageCode;
        this.message = message;
    }


    public int getMessageCode() {
        return messageCode;
    }


    public void setMessageCode(int messageCode) {
        this.messageCode = messageCode;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isSuccess() {
        if (this.type == TYPE_RESULT_SUCCESS) {
            return true;
        }
        return false;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }


    public Map<String, Object> getSysdata() {
        return sysdata;
    }


    public void setSysdata(Map<String, Object> sysdata) {
        this.sysdata = sysdata;
    }


}
