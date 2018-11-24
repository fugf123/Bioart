package com.xiaowa.bioart.util;

import com.xiaowa.bioart.exception.ExceptionResultInfo;
import com.xiaowa.bioart.result.ResultInfo;
import com.xiaowa.bioart.result.SubmitResultInfo;

import java.util.List;


/**
 * ϵͳ���������
 *
 * @author mrt
 */
public class ResultUtil {


    /**
     * ����������
     *
     * @param //MESSAGE
     * @return
     */
    public static ResultInfo createFail(String fileName, int messageCode, Object[] objs) {
        String message = null;
        if (objs == null) {
            message = ResourcesUtil.getValue(fileName, messageCode + "");
        } else {
            message = ResourcesUtil.getValue(fileName, messageCode + "", objs);
        }

        return new ResultInfo(ResultInfo.TYPE_RESULT_FAIL, messageCode, message);
    }

    /**
     * ����������ʾ���
     */
    public static ResultInfo createWarning(String fileName, int messageCode, Object[] objs) {
        String message = null;
        if (objs == null) {
            message = ResourcesUtil.getValue(fileName, messageCode + "");
        } else {
            message = ResourcesUtil.getValue(fileName, messageCode + "", objs);
        }
        return new ResultInfo(ResultInfo.TYPE_RESULT_WARN, messageCode, message);
    }

    /**
     * �����ɹ���ʾ���
     */
    public static ResultInfo createSuccess(String fileName, int messageCode, Object[] objs) {

        String message = null;
        if (objs == null) {
            message = ResourcesUtil.getValue(fileName, messageCode + "");
        } else {
            message = ResourcesUtil.getValue(fileName, messageCode + "", objs);
        }
        return new ResultInfo(ResultInfo.TYPE_RESULT_SUCCESS, messageCode, message);
    }


    /**
     * ������ͨ��Ϣ��ʾ���
     */
    public static ResultInfo createInfo(String fileName, int messageCode, Object[] objs) {

        String message = null;
        if (objs == null) {
            message = ResourcesUtil.getValue(fileName, messageCode + "");
        } else {
            message = ResourcesUtil.getValue(fileName, messageCode + "", objs);
        }
        return new ResultInfo(ResultInfo.TYPE_RESULT_INFO, messageCode, message);
    }


    /**
     * �׳��쳣
     *
     * @param resultInfo
     * @throws //ExceptionResultInfo
     */
    public static void throwExcepion(ResultInfo resultInfo) throws ExceptionResultInfo {
        throw new ExceptionResultInfo(resultInfo);
    }

    public static void throwExcepion(ResultInfo resultInfo, List<ResultInfo> details) throws ExceptionResultInfo {
        if (resultInfo != null) {
            resultInfo.setDetails(details);
        }
        throw new ExceptionResultInfo(resultInfo);
    }

    /**
     * �����ύ�����Ϣ
     *
     * @param resultInfo
     * @return
     */
    public static SubmitResultInfo createSubmitResult(ResultInfo resultInfo) {
        return new SubmitResultInfo(resultInfo);
    }

    /**
     * �����ύ�����Ϣ��������ϸ��Ϣ
     *
     * @param resultInfo
     * @param details
     * @return
     */
    public static SubmitResultInfo createSubmitResult(ResultInfo resultInfo, List<ResultInfo> details) {
        if (resultInfo != null) {
            resultInfo.setDetails(details);
        }
        return new SubmitResultInfo(resultInfo);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
