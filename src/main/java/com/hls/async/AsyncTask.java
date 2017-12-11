package com.hls.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Package: com.hls.async
 * @Author: helishi
 * @CreateDate: 2017/12/8
 * @Description:
 */
@Component  //作为bean被注入支持的注解
public class AsyncTask {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private Random random = new Random();

    @Async
    public void  doTaskOne()throws Exception{
        logger.info("AsyncTask.doTaskOne");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        logger.info("finished task 1 , consume:" + (end - start));
    }

    @Async
    public void  doTaskTwo()throws Exception{
        logger.info("AsyncTask.doTaskTwo");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        logger.info("finished task 2 , consume:" + (end - start));
    }

    @Async
    public void  doTaskThree()throws Exception{
        logger.info("AsyncTask.doTaskThree");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        logger.info("finished task 3 , consume:" + (end - start));
    }
}
