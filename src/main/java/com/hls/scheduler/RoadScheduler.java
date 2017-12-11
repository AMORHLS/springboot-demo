package com.hls.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @Package: com.hls.scheduler
 * @Author: helishi
 * @CreateDate: 2017/12/8
 * @Description: 定时任务
 */
@Configuration
@EnableScheduling
public class RoadScheduler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    //@Scheduled(cron = "0/2 * * * * ?")//每2秒执行 cron表达式
    public void schedule(){
        logger.info(">>>>>>>>>>>RoadScheduler>>>>>schedule");
    }
}
