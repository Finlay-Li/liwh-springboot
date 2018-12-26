package com.dodou.liwh.quartz.hello;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: Liwh
 * @ClassName: HelloQuartz
 * @Description: 我们的第一个quartz任务
 * @version: 1.0.0
 * @date: 2018-12-20 11:19 AM
 */
@DisallowConcurrentExecution
public class HelloQuartz implements Job {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = format.format(date);
        logger.info("Current execute time :" + s);
        //任务的业务逻辑：发放稳健基金收益
        System.out.println("Hello Quartz :任务的业务逻辑：发放稳健基金收益");

        //获取JobDetailMap
        JobDataMap jobDetailDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        String var1 = jobDetailDataMap.getString("StringValue");
        System.out.println(var1);

        JobDataMap triggerDataMap = jobExecutionContext.getTrigger().getJobDataMap();
        String var2 = triggerDataMap.getString("StringValue");
        System.out.println(var2);
    }
}
