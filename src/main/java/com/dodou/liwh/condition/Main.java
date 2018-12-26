package com.dodou.liwh.condition;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: Liwh
 * @ClassName: Main
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-15 12:07 PM
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(ConditionConfig.class);
        CmdListService bean = ioc.getBean(CmdListService.class);
        bean.cmd();
    }
}
