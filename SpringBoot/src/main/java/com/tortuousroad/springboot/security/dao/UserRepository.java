package com.tortuousroad.springboot.security.dao;

import com.tortuousroad.springboot.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * UserRepository
 *
 * @author GuFeng
 * @version 1.0
 * @since 2017/6/12 上午12:02
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

    User findByNameAndAge(String name, Integer age);

    @Query("select u from User u where u.name = :name and u.password = :password")
    User login(@Param("name") String name, @Param("password") String password);

}
