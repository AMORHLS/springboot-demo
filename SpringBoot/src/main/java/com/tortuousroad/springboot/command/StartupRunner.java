package com.tortuousroad.springboot.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 * Command Line
 *
 * @author GuFeng
 * @version 1.0
 * @since 2017/6/11 下午11:51
 */
@Component
@Order(1)
public class StartupRunner implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void run(String... args) throws Exception {
        logger.info("StartupRunner.run.");
    }

}
