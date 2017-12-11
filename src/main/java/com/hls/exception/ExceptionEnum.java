package com.hls.exception;

/**
 * @Package: com.hls.exception
 * @Author: helishi
 * @CreateDate: 2017/12/9
 * @Description:
 */
public enum ExceptionEnum {
    UNKNOW_ERROR(-1,"未知错误"),
    ERROR(1,"失败"),
    NAMENOTFOUND(2,"用户名错误！"),
    PWDERROR(3,"密码错误！"),
    ERRORLOGINEXCEPTION(4,"用户名或者密码错误！")
    ;

    private Integer code;
    private String msg;

    ExceptionEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
