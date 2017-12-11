package com.hls.security.controller;

import com.hls.exception.Result;
import com.hls.exception.ResultUtil;
import com.hls.exception.handle.ExceptionHandle;
import com.hls.security.entity.User;
import com.hls.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Package: com.hls.security.controller
 * @Author: helishi
 * @CreateDate: 2017/12/8
 * @Description:登录控制器
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private ExceptionHandle exceptionHandle;


    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("username","no user");
        return "login";
    }

    /*@PostMapping("/login")
    @ResponseBody  //注意返回的是数据的时候加此注解
    public String login(String username,String password){
        return username+"---"+password;
    }*/

    @PostMapping("/login")
    public String login(Model model,String username,String password){
        User user = null;
        Result result = ResultUtil.success();
        try {
            user = userService.login(username,password);
        } catch (Exception e) {
            //这里不要使用e.printStackTrace() 否则会交个jvm处理了
            result = exceptionHandle.exceptionGet(e);
        }
            model.addAttribute("username",user == null?"no user":user.getName() );
            model.addAttribute("msg",result.getMsg()==null?"no":result.getMsg() );
            return "index";
    }
}
