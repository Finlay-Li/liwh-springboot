package com.dodou.liwh.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: Liwh
 * @ClassName: Main
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-10 3:40 PM
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(JavaConfig.class);
        UseFunctionService useFunctionService = (UseFunctionService) ioc.getBean("useFunctionService");
        System.out.println(useFunctionService.sayHello());
    }
}
