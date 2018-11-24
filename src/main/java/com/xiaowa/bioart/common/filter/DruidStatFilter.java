package com.xiaowa.bioart.common.filter;

import com.alibaba.druid.support.http.WebStatFilter;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Created by Administrator on 2018/1/29.
 * 配置druid监控统计功能
 * 配置Filter
 */
@WebFilter(filterName = "druidWebStatFilter",  urlPatterns = "/*",
        initParams = {
                @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid*//*")// 忽略资源
        })
public class DruidStatFilter extends WebStatFilter {
}
