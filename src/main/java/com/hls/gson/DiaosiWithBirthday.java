package com.hls.gson;

/**
 * @Package: com.hls.gson
 * @Author: helishi
 * @CreateDate: 2017/12/12
 * @Description:
 */
public class DiaosiWithBirthday {
    private String birthday;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "DiaosiWithBirthday{" +
                "birthday='" + birthday + '\'' +
                '}';
    }
}
