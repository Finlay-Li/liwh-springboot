package com.dodou.liwh.taskexecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: Liwh
 * @ClassName: Main
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-14 2:44 PM
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService service = ioc.getBean(AsyncTaskService.class);
        for (int i = 0; i < 5; i++) {
            service.asyncAction1(i);
            service.asyncAction2(i);
        }
        ioc.close();
    }
}
