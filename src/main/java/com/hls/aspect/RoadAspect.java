package com.hls.aspect;

import com.hls.exception.Result;
import com.hls.exception.handle.ExceptionHandle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Package: com.hls.aspect
 * @Author: helishi
 * @CreateDate: 2017/12/8
 * @Description: 使用@Aspect来声明这是一个切面，使用@Pointcut来定义切面所需要切入的位置，
 * 这里我们是对每一个HTTP请求都需要切入，在进入方法之前我们使用@Before记录了调用的接口URL，
 * 调用的方法，调用方的IP地址以及输入的参数等。在整个接口代码运作期间，我们使用@Around来捕获异常信息，
 * 并用之前定义好的Result进行异常的返回，最后我们使用@AfterReturning来记录我们的出參
 */
@Aspect
@Component
@Order(1) //顺序
public class RoadAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private final static Logger LOGGER = LoggerFactory.getLogger(RoadAspect.class);

    @Autowired
    private ExceptionHandle exceptionHandle;

    @Pointcut("execution(public * com.hls.security.controller.*.*(..))")
    public void log(){ }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        LOGGER.info("url={}",request.getRequestURL());
        //method
        LOGGER.info("method={}",request.getMethod());
        //ip
        LOGGER.info("id={}",request.getRemoteAddr());
        //class_method
        LOGGER.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName());
        //args[]
        LOGGER.info("args={}",joinPoint.getArgs());
    }

    @Around("log()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Result result = null;
        try {

        } catch (Exception e) {
            return exceptionHandle.exceptionGet(e);
        }
        if(result == null){
            return proceedingJoinPoint.proceed();
        }else {
            return result;
        }
    }

    @AfterReturning(pointcut = "log()",returning = "object")//打印输出结果
    public void doAfterReturing(Object object){
        //LOGGER.info("response={}",object.toString());
    }

    //测试(学习AOP)
    @Around(value = "execution(public * com.hls.security.controller.*Controller.*(..))")
    public Object around(final ProceedingJoinPoint proceedingJoinPoint){
        logger.info("RoadAspect##########around");
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }
}
