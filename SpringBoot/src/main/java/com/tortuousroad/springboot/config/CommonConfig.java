package com.tortuousroad.springboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

/**
 *
 * 公用配置
 *
 * @author GuFeng
 * @version 1.0
 * @since 2017/6/11 下午10:27
 */
@Configuration
public class CommonConfig implements EnvironmentAware {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${spring.application.name:DefaultApplication}")
    private String applicationName;

    @PostConstruct
    public void init() {
        logger.info("CommonConfig-1:" + applicationName);
    }

    @Override
    public void setEnvironment(Environment environment) {
        logger.info("CommonConfig-2:" + environment.getProperty("spring.application.name"));
        logger.info("CommonConfig-3:" + environment.getProperty("spring.application.name1"));
        logger.info("CommonConfig-4:" + environment.getProperty("server.port"));
    }
}
