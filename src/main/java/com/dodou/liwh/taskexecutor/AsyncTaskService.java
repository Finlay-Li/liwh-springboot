package com.dodou.liwh.taskexecutor;

import com.dodou.liwh.mybatis.dao.model.MpUser;
import com.dodou.liwh.mybatis.service.MpUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: Liwh
 * @ClassName: AsyncTaskService
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-14 2:40 PM
 */
@Component
public class AsyncTaskService {
//    @Autowired
//    MpUserService mpUserService;

    //自动加入spring线程池
    @Async
    public void asyncAction1(int i) {
        System.out.println("async1:" + i+"线程名："+Thread.currentThread().getName());
    }

    @Async
    public void asyncAction2(int i) {
        System.out.println("async2:" + (i + 1)+"线程名："+Thread.currentThread().getName());
    }

//    @Async
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public void other1(MpUser mpUser) {
//        MpUser mpUser1 = new MpUser();
//        mpUser1.setAge(mpUser.getAge());
//        mpUser1.setName("other-1");
//        mpUser1.setUserEmail("test@qq.com");
//        mpUserService.save(mpUser1);
////        if (1 == 1) {
////            throw new RuntimeException("中断测试");
////        }
//        other2(mpUser);
//    }
//
//    @Async
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public void other2(MpUser mpUser) {
//        MpUser mpUser2 = new MpUser();
//        mpUser2.setAge(mpUser.getAge());
//        mpUser2.setName("other-2");
//        mpUser2.setUserEmail("test@qq.com");
//        mpUserService.save(mpUser2);
////        if (1 == 1) {
////            throw new RuntimeException("中断测试");
////        }
//        int i = 1 / 0;
//    }
}
