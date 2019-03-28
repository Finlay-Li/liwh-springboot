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
        //已标注@AppleName的类
        AnnotationAction annotationAction = (AnnotationAction) context.getBean("annotationAction");
        annotationAction.eat();
        //未标注@AppleName的类
        MethodAction methodAction = (MethodAction) context.getBean("methodAction");
        methodAction.eat();
    }
}
