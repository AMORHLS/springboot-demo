package com.hls.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

/**
 * @Package: com.hls.config
 * @Author: helishi
 * @CreateDate: 2017/12/8
 * @Description: 通用配置
 *      读取配置文件的三种方式
 *          1、使用@Value注解变量方式
 *          2、使用@ConfigurationProperties注解类方式
 *          3、实现EnvironmentAware接口
 */
@Configuration
public class CommonConfig implements EnvironmentAware{
    private Logger logger = LoggerFactory.getLogger(getClass());

    //若是spring.application.name无或者错误会报错  可以写默认值name1:DefaultApplication
    @Value("${spring.application.name:DefaultApplication}")
    private String applicationName;


    @PostConstruct  //构造的时候使用，验证是否拿到
    public void init(){
        logger.info("CommonConfig------方式一:"+applicationName);
    }

    @Override
    public void setEnvironment(Environment environment) {
        logger.info("CommonConfig------方式三:"+environment.getProperty("spring.application.name"));
        //"spring.application.name1" 没有或者错误  不会报错   显示结果为null
       /* logger.info("CommonConfig------方式三:"+environment.getProperty("spring.application.name1"));
        logger.info("CommonConfig------方式三:"+environment.getProperty("server.port"));*/
    }
}
