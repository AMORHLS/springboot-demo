package com.tortuousroad.springboot;

import com.tortuousroad.springboot.banner.RoadBanner;
import com.tortuousroad.springboot.config.RoadConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 *
 * 启动入口
 *
 * @author GuFeng
 * @version 1.0
 * @since 2017/6/11 下午9:55
 */
@SpringBootApplication
@EnableConfigurationProperties({RoadConfig.class})
@ServletComponentScan
@EnableAsync
public class RoadApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(RoadApplication.class);
        springApplication.setBanner(new RoadBanner());
        springApplication.run(args);
    }

}
