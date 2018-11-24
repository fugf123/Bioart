package com.xiaowa.bioart.common.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2018/1/29
 * 自定义webapp配置文件. 基础mvc配置适配器
 */
@Configuration
public class BioArtWebAppConfigurer extends WebMvcConfigurerAdapter{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //多个拦截器组成一个拦截器链
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**");

        super.addInterceptors(registry);
    }
}
