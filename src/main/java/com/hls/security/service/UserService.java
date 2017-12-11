package com.hls.security.service;

import com.hls.exception.ExceptionEnum;
import com.hls.exception.MyException;
import com.hls.exception.Result;
import com.hls.exception.ResultUtil;
import com.hls.security.dao.UserRepository;
import com.hls.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package: com.hls.security.service
 * @Author: helishi
 * @CreateDate: 2017/12/8
 * @Description:
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(String name,String password)throws Exception{
        User user = userRepository.login(name,password);
        if (user == null){
            throw new MyException(ExceptionEnum.ERRORLOGINEXCEPTION);
        }else {
            return user;
        }
    }
}
