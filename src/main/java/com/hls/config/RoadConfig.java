package com.hls.config;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;

/**
 * @Package: com.hls.config
 * @Author: helishi
 * @CreateDate: 2017/12/8
 * @Description: 读取配置文件方式二
 *      注意安装lombok插件,在启动类需要增加注解（1.4.4版本）@EnableConfigurationProperties(RoadConfig.class)
 */
@ConfigurationProperties(prefix = "road",locations = "classpath:config/road.yml")
public class RoadConfig {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private Integer age;

    @PostConstruct
    public void init(){
        logger.info("RoadConfig-----方式二"+this.getName());
        logger.info("RoadConfig-----方式二"+this.getAge());
    }

}
