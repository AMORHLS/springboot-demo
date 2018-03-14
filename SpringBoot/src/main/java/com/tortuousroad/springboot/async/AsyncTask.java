package com.tortuousroad.springboot.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 *
 * 异步任务
 *
 * @author GuFeng
 * @version 1.0
 * @since 2017/6/11 下午11:44
 */
@Component
public class AsyncTask {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private Random random = new Random();

    @Async
    public void doTaskOne() throws Exception {
        logger.info("Start task 1.");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        logger.info("Finished task 1, consume: " + (end - start) + " ms.");
    }

    @Async
    public void doTaskTwo() throws Exception {
        logger.info("Start task 2.");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        logger.info("Finished task 2, consume: " + (end - start) + " ms.");
    }

    @Async
    public void doTaskThree() throws Exception {
        logger.info("Start task 3.");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        logger.info("Finished task 3, consume: " + (end - start) + " ms.");
    }

}
