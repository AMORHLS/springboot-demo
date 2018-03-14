package com.tortuousroad.springboot.config;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;

/**
 *
 * 自定义配置读取
 *
 * @author GuFeng
 * @version 1.0
 * @since 2017/6/11 下午10:34
 */
@ConfigurationProperties(prefix = "road", locations = "classpath:config/road.yml")
public class RoadConfig {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Integer age;

    @PostConstruct
    public void init() {
        logger.info("RoadConfig-1:" + this.getName());
        logger.info("RoadConfig-2:" + this.getAge());
    }

}
