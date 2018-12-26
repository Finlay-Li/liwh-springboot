package com.dodou.liwh.taskexecutor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author: Liwh
 * @ClassName: TaskExecutorConfig
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-14 12:18 PM
 */
@Configurable
@ComponentScan("com.dodou.liwh.taskexecutor")
@EnableAsync
public class TaskExecutorConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        //java executor
        //ExecutorService executor = Executors.newFixedThreadPool(5);
        //线程无法自动加入，因为要submit(thread)
        //spring taskExecutor

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(10);
        executor.setCorePoolSize(5);
        executor.setQueueCapacity(20);
        //配置后初始化线程池
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
