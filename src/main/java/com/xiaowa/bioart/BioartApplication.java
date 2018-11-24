package com.xiaowa.bioart;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/***
 * ServletComponentScan 扫描自定义Servlet和filter
 */
@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
@MapperScan(basePackages = {"com.xiaowa.bioart.mapper"})
public class BioartApplication {
    private static Logger logger = Logger.getLogger(BioartApplication.class);
    static {
        try{
            // 初始化log4j
            String log4jPath = "";
//			if(Constant.LOG_MODE == 1){
//				// 配置线上地址
//				log4jPath = Fugaofei001Application.class.getClassLoader().getResource("").getPath()+"pms-api-services/config/log4j.properties";
//				logger.info("Log4j线上生产模式初始化。。。");
//			}else{
            // 配置本地地址
            log4jPath = BioartApplication.class.getClassLoader().getResource("").getPath()+"log4j.properties";
            logger.info("Log4j线下开发模式初始化。。。");
//			}
            logger.info("初始化Log4j。。。。");
            logger.info("path is "+ log4jPath);
            PropertyConfigurator.configure(log4jPath);
        }catch (Exception e){
            logger.error(e.toString());
        }
    }
    public static void main(String[] args) {
        SpringApplication.run(BioartApplication.class, args);
    }

//    /**
//     * 分页插件
//     */
//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        return new PaginationInterceptor();
//    }
}
