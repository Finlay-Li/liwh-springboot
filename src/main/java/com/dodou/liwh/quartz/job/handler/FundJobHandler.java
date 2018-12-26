package com.dodou.liwh.quartz.job.handler;

import org.springframework.stereotype.Component;

/**
 * @author: Liwh
 * @ClassName: FundJobHandler
 * @Description:
 * @version: 1.0.0
 * @date: 2018-12-22 11:41 AM
 */
@Component
public class FundJobHandler {

    public void start(){
        System.out.println("=================开始计算稳健基金===================");
    }
}
