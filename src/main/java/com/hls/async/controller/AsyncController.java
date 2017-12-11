package com.hls.async.controller;

import com.hls.async.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package: com.hls.async.controller
 * @Author: helishi
 * @CreateDate: 2017/12/8
 * @Description: 异步任务控制器
 */
@RestController
public class AsyncController {

    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping("/task")
    public String doTask()throws Exception{
        asyncTask.doTaskOne();
        asyncTask.doTaskTwo();
        asyncTask.doTaskThree();
        return "submit tasks";
    }
}
