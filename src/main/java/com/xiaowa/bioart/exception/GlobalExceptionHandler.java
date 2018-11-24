package com.xiaowa.bioart.exception;

import com.xiaowa.bioart.result.ResultInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hsdev-08 on 2017-11-21.
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map<String, Object> jsonHandler(HttpServletRequest request, Exception ex) throws Exception {
        ResultInfo resultInfo;
        if (ex instanceof ExceptionResultInfo) {
            // �׳�����ϵͳ�Զ����쳣
            resultInfo = ((ExceptionResultInfo) ex).getResultInfo();

            HashMap<String, Object> resultMap = new HashMap<>();
            resultMap.put("resultInfo", resultInfo);
            return resultMap;
        } else {
            // ���¹��조δ֪�����쳣
            ex.printStackTrace();
            HashMap<String, Object> resultMap = new HashMap<>();
            resultMap.put("resultInfo", ex);
            return resultMap;
        }
    }
}
