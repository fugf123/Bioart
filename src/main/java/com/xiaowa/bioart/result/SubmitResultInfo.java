package com.xiaowa.bioart.result;


/**
 * ϵͳ�ύ����������
 *
 * @author Thinkpad
 */
public class SubmitResultInfo {

    public SubmitResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }

    //���������Ϣ
    private ResultInfo resultInfo;

    public ResultInfo getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }

}
