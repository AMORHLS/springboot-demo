package com.tortuousroad.springboot.async.controller;

import com.tortuousroad.springboot.async.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * 异步任务入口
 *
 * @author GuFeng
 * @version 1.0
 * @since 2017/6/11 下午11:44
 */
@Controller
public class AsyncController {

    @Autowired
    private AsyncTask task;

    @RequestMapping("/task")
    @ResponseBody
    public String doTask() throws Exception {
        task.doTaskOne();
        task.doTaskTwo();
        task.doTaskThree();
        return "Submit tasks.";
    }

}
