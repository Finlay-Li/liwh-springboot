package com.dodou.liwh.annotation;

import org.springframework.stereotype.Service;

/**
 * @author: Liwh
 * @ClassName: Apple
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-10 5:50 PM
 */
@Service
public class AnnotationAction {

    //使用了@AppleName注解，满足aop切入点方法：进行切入
    @AppleName(name = "我吃苹果")
    public void eat() {
        //被切入的方法
    }
}
