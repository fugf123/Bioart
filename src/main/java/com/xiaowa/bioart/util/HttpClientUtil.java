package com.xiaowa.bioart.util; /**
 * Created by hsdev-04 on 2017-03-15.
 */

import com.alibaba.fastjson.JSON;
import com.xiaowa.bioart.common.ErrorService;
import com.xiaowa.bioart.entity.RespondParam;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HttpClientUtil {
    /**
     * get��ȡ�ַ���
     */
    public static void requestgetStream(String url, HttpServletResponse resp) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpEntity returnd = null;
        try {
            // ����httpget.
            HttpGet httpget = new HttpGet(url);

            // ִ��get����.
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                // ��ȡ��Ӧʵ��
                HttpEntity entity = response.getEntity();
                System.out.println("--------------------------------------");
                // ��ӡ��Ӧ״̬

                if (entity != null) {
                    // ��ӡ��Ӧ���ݳ���

                    // ��ӡ��Ӧ����

                    String contenttype = entity.getContentType().getValue();
                    if (contenttype.equals("image/jpeg")) {
                        try {
                            resp.setHeader("Content-Type", "image/jped");
                            entity.writeTo(resp.getOutputStream());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        PrintWriter out = null;
                        RespondParam respondParam = new RespondParam();
                        respondParam.setWebSvcError(ErrorService.superSvcError("-1", "��ȡ����ʧ��", "").toJSONString());
                        try {
                            out = resp.getWriter();
                            out.append(JSON.toJSONString(respondParam));
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            if (out != null) {
                                out.close();
                            }
                        }
                    }


                }
                System.out.println("------------------------------------");
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // �ر�����,�ͷ���Դ
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * get��ȡ�ַ���
     */
    public static String requestgetString(String url) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String returnd = null;
        try {
            // ����httpget.
            HttpGet httpget = new HttpGet(url);

            // ִ��get����.
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                // ��ȡ��Ӧʵ��
                HttpEntity entity = response.getEntity();
                System.out.println("--------------------------------------");
                // ��ӡ��Ӧ״̬

                if (entity != null) {
                    // ��ӡ��Ӧ���ݳ���

                    // ��ӡ��Ӧ����
                    String entityString = EntityUtils.toString(entity);
                    System.out.println("Response content: " + entityString);
                    returnd = entityString;
                }
                System.out.println("------------------------------------");
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // �ر�����,�ͷ���Դ
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return returnd;
    }
}
