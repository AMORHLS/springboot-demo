package com.hls.web.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Package: com.hls.web.listener
 * @Author: helishi
 * @CreateDate: 2017/12/8
 * @Description: 监听器
 */
@WebListener
public class RoadListener implements ServletContextListener {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("RoadListener$$$$$$$$$$$$$$$$$$contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("RoadListener$$$$$$$$$$$$$$$$$$contextDestroyed");
    }
}
