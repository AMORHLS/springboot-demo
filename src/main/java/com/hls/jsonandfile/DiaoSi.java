package com.hls.jsonandfile;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * @Package: com.hls.jsonandfile
 * @Author: helishi
 * @CreateDate: 2017/12/11
 * @Description: 使用javabean方式构建json对象
 */
public class DiaoSi {
    //该注解能让属性name变为大写NAME
    //@SerializedName("name")
    private String name;
    private String school;
    private Boolean has_girlfriend;
    private double age;
    private Object car;
    private Object house;
    private String[] major;
    private String comment;
    private String birthday;
    //transient 在生成json的时候忽略该属性
    private transient String ignore;

    @Override
    public String toString() {
        return "test{" +
                "name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", has_girlfriend=" + has_girlfriend +
                ", age=" + age +
                ", car=" + car +
                ", house=" + house +
                ", major=" + Arrays.toString(major) +
                ", comment='" + comment + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Boolean getHas_girlfriend() {
        return has_girlfriend;
    }

    public void setHas_girlfriend(Boolean has_girlfriend) {
        this.has_girlfriend = has_girlfriend;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public Object getCar() {
        return car;
    }

    public void setCar(Object car) {
        this.car = car;
    }

    public Object getHouse() {
        return house;
    }

    public void setHouse(Object house) {
        this.house = house;
    }

    public String[] getMajor() {
        return major;
    }

    public void setMajor(String[] major) {
        this.major = major;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
