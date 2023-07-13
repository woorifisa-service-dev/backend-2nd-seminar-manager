package com.woorifisa.seminar.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ExceptionLoggingAop {

    /**
     * 예외 처리 전 로깅
     */
    @Around("execution(* com.woorifisa.seminar.exception.advice.*.*(..))")
    public Object logException(ProceedingJoinPoint pjp) throws Throwable {
        for (Object o : pjp.getArgs()) {
            if (o instanceof Exception) {
                Exception e = (Exception) o;
                log.error("", e);
            }
        }

        return pjp.proceed();
    }

}
