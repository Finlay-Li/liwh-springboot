package com.dodou.liwh.mybatis.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dodou.liwh.mybatis.dao.model.MpUser;
import com.dodou.liwh.mybatis.service.MpUserService;
import com.dodou.liwh.taskexecutor.AsyncTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Liwh
 * @ClassName: UserController
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-08 10:31 AM
 */
@RestController
public class MybatisUserController {

    @Autowired
    private MpUserService mpUserService;
    @Autowired
    private AsyncTaskService asyncTaskService;
    @Autowired
    private DataSourceTransactionManager transactionManager;

    @RequestMapping(value = "/user/{id}", produces = {"application/json;charset=utf-8"})
    public MpUser queryById(@PathVariable("id") Long id) {
        MpUser mpUser = mpUserService.queryById(id);
        return mpUser;
    }

    @RequestMapping(value = "/addUser", produces = {"application/json;charset=utf-8"})
    public void addUser() {
        mpUserService.insterTransactional();
    }

    @RequestMapping(value = "/page", produces = {"application/json;charset=utf-8"})
    public Page page(@RequestParam(value = "current", required = false, defaultValue = "1") Integer current
            , @RequestParam(value = "size", required = false, defaultValue = "3") Integer size
    ) {
        Page page = mpUserService.queryUserByPage(current, size);
        return page;
    }

    @RequestMapping(value = "/batchAdd")
    @Transactional(rollbackFor = Exception.class)
    public List<MpUser> batchAdd() {
        //批量插入不重复时：Set<MpUser> set = Sets.newConcurrentHashSet();
        List<MpUser> list = new ArrayList<>();
        MpUser mpUser = new MpUser();
        try {
            mpUser.setAge(18);
            mpUser.setName("test");
            mpUser.setUserEmail("test@qq.com");
//        mpUserService.saveBatch(list,3);
            mpUserService.save(mpUser);

            throw new RuntimeException("中断测试");
        } catch (Exception e) {
            //catch----无法回滚
            //手动

            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            asyncTaskService.other(mpUser);
        }
        System.out.println("--------------------其他");
        return list;
    }


}
