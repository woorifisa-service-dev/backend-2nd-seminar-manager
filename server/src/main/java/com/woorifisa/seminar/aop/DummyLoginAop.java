package com.woorifisa.seminar.aop;

import com.woorifisa.seminar.dto.MemberInfo;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@Slf4j
public class DummyLoginAop {

    @Around("execution(* com.woorifisa.seminar.controller.*.*(..))")
    public Object login(ProceedingJoinPoint pjp) throws Throwable {
        log.info("Dummy Login");

        HttpServletRequest request =
            ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        request.getSession().setAttribute(MemberInfo.KEY, MemberInfo.getDummy());
        request.getSession().setAttribute("MENTOR", MemberInfo.getDummyMentor());
        request.getSession().setAttribute("TEACHER", MemberInfo.getDummyTeacher());

        return pjp.proceed();
    }
}
