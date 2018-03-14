package com.tortuousroad.springboot.security.service;

import com.tortuousroad.springboot.security.dao.UserRepository;
import com.tortuousroad.springboot.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * UserService
 *
 * @author GuFeng
 * @version 1.0
 * @since 2017/6/12 上午12:06
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(String name, String password) {
        return userRepository.login(name, password);
    }

}
