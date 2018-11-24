package com.xiaowa.bioart.util.spring;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * Created by hsdev-04 on 2017-02-09.
 */
public class SpringApplicationContextInitializer implements ApplicationContextInitializer<XmlWebApplicationContext> {


    public void initialize(XmlWebApplicationContext applicationContext) {
        applicationContext.setAllowBeanDefinitionOverriding(false);//�����ｫXmlWebApplicationContext����allowBeanDefinitionOverriding����Ϊfalse,�����
        //�Ե�ֵ���ջᴫ�ݸ�DefaultListableBeanFactory���allowBeanDefinitionOverriding����
    }
}
