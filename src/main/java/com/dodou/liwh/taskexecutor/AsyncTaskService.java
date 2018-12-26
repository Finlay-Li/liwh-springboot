package com.dodou.liwh.taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author: Liwh
 * @ClassName: AsyncTaskService
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-14 2:40 PM
 */
@Component
public class AsyncTaskService {
    //自动加入spring线程池
    @Async
    public void asyncAction1(int i) {
        System.out.println("async1:" + i);
    }

    @Async
    public void asyncAction2(int i) {
        System.out.println("async2:" + (i + 1));
    }
}
