package com.dodou.liwh.quartz.job;

import com.dodou.liwh.quartz.job.handler.FundJobHandler;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: Liwh
 * @ClassName: FundJob
 * @Description: 它的实例由Scheduler创建
 * @version: 1.0.0
 * @date: 2018-12-22 11:36 AM
 */
@PersistJobDataAfterExecution//保存在JobDataMap传递的参数,当你要一个计数器的时候,详情可参见博客
@DisallowConcurrentExecution
public class FundJob implements Job {
    @Autowired
    private FundJobHandler fundJobHandler;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        fundJobHandler.start();
    }
}
