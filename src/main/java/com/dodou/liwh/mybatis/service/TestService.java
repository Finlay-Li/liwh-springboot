package com.dodou.liwh.mybatis.service;

import com.dodou.liwh.mybatis.dao.model.MpUser;
import com.dodou.liwh.taskexecutor.AsyncTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Liwh
 * @ClassName: TestService
 * @Description:
 * @version: 1.0.0
 * @date: 2019-01-11 9:46 AM
 */
@Component
public class TestService {
    @Autowired
    private AsyncTaskService asyncTaskService;
    @Autowired
    private MpUserService mpUserService;

    public void test() {
        //批量插入不重复时：Set<MpUser> set = Sets.newConcurrentHashSet();
        List<MpUser> list = new ArrayList<>();
        MpUser mpUser = new MpUser();
        mpUser.setAge(18);
        mpUser.setName("test");
        mpUser.setUserEmail("test@qq.com");
//        mpUserService.save(mpUser);
        asyncTaskService.other1(mpUser);
        System.out.println("--------------------其他");
    }


}
