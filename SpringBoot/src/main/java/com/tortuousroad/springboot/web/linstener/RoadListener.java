package com.tortuousroad.springboot.web.linstener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * 监听器
 *
 * @author GuFeng
 * @version 1.0
 * @since 2017/6/11 下午11:34
 */
@WebListener
public class RoadListener implements ServletContextListener {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("RoadListener.contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("RoadListener.contextDestroyed");
    }
}
