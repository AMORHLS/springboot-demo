package com.hls.exception.handle;

import com.hls.exception.ExceptionEnum;
import com.hls.exception.MyException;
import com.hls.exception.Result;
import com.hls.exception.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Package: com.hls.exception.handle
 * @Author: helishi
 * @CreateDate: 2017/12/9
 * @Description:
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * 判断错误是否是已定义的已知错误，不是则由未知错误代替，同时记录在log中
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionGet(Exception e){
        if(e instanceof MyException){
            MyException MyException = (MyException) e;
            return ResultUtil.error(MyException.getCode(),MyException.getMessage());
        }else {
            LOGGER.error("【系统异常】{}",e);
            return ResultUtil.error(ExceptionEnum.UNKNOW_ERROR);
        }

    }
}
