package com.hls.security.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


/**
 * @Package: com.hls.security.entity
 * @Author: helishi
 * @CreateDate: 2017/12/8
 * @Description: 用户实体
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Column(name = "name",nullable = false)
    @Getter
    @Setter
    private String name;

    @Column(name = "password",nullable = false)
    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private Integer age;
}
