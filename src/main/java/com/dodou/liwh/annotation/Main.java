package com.dodou.liwh.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: Liwh
 * @ClassName: Main
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-10 6:03 PM
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        AnnotationAction annotationAction = (AnnotationAction) context.getBean("annotationAction");
        annotationAction.eat();
        MethodAction methodAction = (MethodAction) context.getBean("methodAction");
        methodAction.eat();
    }
}
