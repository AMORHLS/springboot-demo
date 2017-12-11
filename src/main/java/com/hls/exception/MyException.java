package com.hls.exception;

/**
 * @Package: com.hls.exception
 * @Author: helishi
 * @CreateDate: 2017/12/9
 * @Description: 自定义异常类  注意spring只对RuntimeException进行事务回滚
 */
public class MyException extends RuntimeException {

    private Integer code;

    /**
     * 继承exception，加入错误状态值
     * @param exceptionEnum
     */
    public MyException(ExceptionEnum exceptionEnum){
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }

    /**
     * 自定义错误信息
     * @param message
     * @param code
     */
    public MyException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
