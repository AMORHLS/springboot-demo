package com.hls.security.dao;

import com.hls.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Package: com.hls.security.dao
 * @Author: helishi
 * @CreateDate: 2017/12/8
 * @Description: UserRepository
 */
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("select u from User u where u.name = :name ")
    User fingByName(String name);

    @Query("select u from User u where u.name = :name and u.age = :age")
    User findByNameAndAge(String name,Integer age);

    @Query("select u from User u where u.name = :name and u.password = :password")
    User login(@Param("name") String name,@Param("password") String password);
}
