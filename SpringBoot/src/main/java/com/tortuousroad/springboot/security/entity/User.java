package com.tortuousroad.springboot.security.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * 用户
 *
 * @author GuFeng
 * @version 1.0
 * @since 2017/6/11 下午11:59
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Column(name = "name", nullable = false)
    @Getter
    @Setter
    private String name;

    @Column(nullable = false)
    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private Integer age;

}
