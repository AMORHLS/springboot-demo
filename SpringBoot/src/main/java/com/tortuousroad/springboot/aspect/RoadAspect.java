package com.tortuousroad.springboot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 * AOP
 *
 * @author GuFeng
 * @version 1.0
 * @since 2017/6/11 下午11:36
 */
@Aspect
@Component
@Order(1)
public class RoadAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Around(value = "execution(public * com.tortuousroad..controller.*Controller.*(..))")
    public Object aroundControllerMethod(final ProceedingJoinPoint pjp) {
        try {
            logger.info("RoadAspect.aroundControllerMethod");
            Object result = pjp.proceed();
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

}
