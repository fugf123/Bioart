package com.xiaowa.bioart.util;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by lenovo on 2018/8/28.
 */
public class FlySaucerUtil {

    /**
     *��htmlCodeת��Ϊpdf�ļ�
     *
     * @param htmlCode  ����body��������������ʽ���ã������޷�ʶ���֡�
     *                    ������ʽ���þ�����style='font-family:SimSun'
     * @param pdfPath ʵ�ʴ��ڵ�ȫ·��pdf�ļ�
     */
    public static void htmlCodeToPdf(String htmlCode, String pdfPath) {
        OutputStream os =null;
        try {
            ITextRenderer renderer = new ITextRenderer();
            os = new FileOutputStream(pdfPath);
            ITextFontResolver fontResolver = renderer.getFontResolver();
            fontResolver.addFont("/fonts/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            renderer.setDocumentFromString(htmlCode);
            renderer.layout();
            renderer.createPDF(os,  true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }finally {
            if(null!=os){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
