package com.xiaowa.bioart.util.spring;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * Created by hsdev-04 on 2017-02-09.
 */
public class SpringApplicationContextInitializer implements ApplicationContextInitializer<XmlWebApplicationContext> {


    public void initialize(XmlWebApplicationContext applicationContext) {
        applicationContext.setAllowBeanDefinitionOverriding(false);//在这里将XmlWebApplicationContext属性allowBeanDefinitionOverriding设置为false,这个属
        //性的值最终会传递给DefaultListableBeanFactory类的allowBeanDefinitionOverriding属性
    }
}
