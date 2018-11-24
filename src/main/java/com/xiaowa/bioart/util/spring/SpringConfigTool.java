package com.xiaowa.bioart.util.spring;

/**
 * Created by hsdev-04 on 2017-02-14.
 */

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringConfigTool implements ApplicationContextAware {// extends ApplicationObjectSupport{

    private static ApplicationContext ac = null;
    private static SpringConfigTool springConfigTool = null;

    public synchronized static SpringConfigTool init() {
        if (springConfigTool == null) {
            springConfigTool = new SpringConfigTool();
        }
        return springConfigTool;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ac = applicationContext;
    }

    public synchronized static Object getBean(String beanName) {
        return ac.getBean(beanName);
    }
}
