package com.dodou.liwh.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author: Liwh
 * @ClassName: LogAspect
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-12 2:18 PM
 */
@Component
@Aspect
public class LogAspect {

    @Pointcut("@annotation(com.dodou.liwh.annotation.AppleName)")
    public void annotationAop() {
    }

    @After("annotationAop()")
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        //使用方法上的注解
        AppleName annotation = method.getAnnotation(AppleName.class);
        System.out.println("注解式拦截：调用自定义注解:" + annotation.setName());
    }

    @Before("execution(* com.dodou.liwh.annotation.MethodAction.*(..))")
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("方法规则拦截：" + method.getName() + ":apple");
    }

}
