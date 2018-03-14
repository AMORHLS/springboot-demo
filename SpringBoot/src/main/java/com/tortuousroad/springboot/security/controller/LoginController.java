package com.tortuousroad.springboot.security.controller;

import com.tortuousroad.springboot.security.entity.User;
import com.tortuousroad.springboot.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * 登录控制器
 *
 * @author GuFeng
 * @version 1.0
 * @since 2017/6/11 下午11:07
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("username", "No user");
        return "login";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    @ResponseBody
//    public String login(String username, String password) {
//        return username + "." + password;
//    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, String username, String password) {
        User user = userService.login(username, password);
        if (null != user) {
            model.addAttribute("username", username);
        } else {
            model.addAttribute("username", "Login failed");
        }
        return "login";
    }

}
