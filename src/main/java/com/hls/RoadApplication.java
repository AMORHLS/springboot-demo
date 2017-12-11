package com.hls;

import com.hls.config.RoadConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Package: PACKAGE_NAME
 * @Author: helishi
 * @CreateDate: 2017/12/8
 * @Description: 启动入口(注意将该类置于包下)
 */
@SpringBootApplication
@EnableConfigurationProperties(RoadConfig.class) //读取配置文件方式二增加的注解
@ServletComponentScan
@EnableAsync  //异步任务的支持注解
public class RoadApplication {

    public static void main(String[] args){
        SpringApplication.run(RoadApplication.class,args);
    }
}
