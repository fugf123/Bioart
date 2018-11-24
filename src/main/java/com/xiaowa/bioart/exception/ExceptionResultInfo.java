package com.xiaowa.bioart.exception;


import com.xiaowa.bioart.result.ResultInfo;

/**
 * �Զ���ϵͳ�쳣��
 */
public class ExceptionResultInfo extends Exception {

    // ϵͳͳһʹ�õĽ���࣬������ ��ʾ��Ϣ���ͺ���Ϣ����
    private ResultInfo resultInfo;

    public ExceptionResultInfo(ResultInfo resultInfo) {
        super(resultInfo.getMessage());
        this.resultInfo = resultInfo;
    }

    public ResultInfo getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }

}
