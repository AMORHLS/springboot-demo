package com.hls.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Package: com.hls.command
 * @Author: helishi
 * @CreateDate: 2017/12/8
 * @Description:  CommandLine
 */
@Component
@Order(2)
public class StartupRunner2 implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void run(String... args) throws Exception {
        logger.info("StartupRunner-2.run");
    }
}
