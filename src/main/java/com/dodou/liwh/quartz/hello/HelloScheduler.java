package com.dodou.liwh.quartz.hello;

import com.dodou.liwh.quartz.hello.HelloQuartz;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author: Liwh
 * @ClassName: HelloScheduler
 * @Description:
 * @version: 1.0.0
 * @date: 2018-12-20 11:27 AM
 */
public class HelloScheduler {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        //1、创建JobDetail,它采用的是Builder模式：绑定我们的Job
        JobBuilder jobBuilder = JobBuilder.newJob(HelloQuartz.class);
        //指定标识
        JobDetail jobDetail = jobBuilder.withIdentity("HelloJob", "1")
                .usingJobData("StringValue", "hei hei 1")
                .usingJobData("DoubleValue", 22.1)
                .build();

        //2、创建Trigger,它采用的是builder模式：立即执行，每2秒执行一次，只执行3次
        TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        //指定标识,执行时间
        triggerBuilder.withIdentity("HelloTrigger", "1");
        //使用SimpleSchedule设置间隔时间，执行的次数
        triggerBuilder.withSchedule(
                CronScheduleBuilder
                        .cronSchedule("* * * * * ? *"));
        CronTrigger trigger = (CronTrigger) triggerBuilder
                .usingJobData("StringValue", "hei hei 2")
                .usingJobData("DoubleValue", 22.2)
                .build();

        //3、创建Scheduler,它采用的是Factory模式
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();//注意，这是SchedulerFactory的实现类
        Scheduler scheduler = schedulerFactory.getScheduler();

        //4、启动Scheduler
        scheduler.start();

        //5、把JobDetail,Trigger放入Scheduler中
        scheduler.scheduleJob(jobDetail, trigger);
        Thread.sleep(3000L);//当睡的时间太大，如30000则会无效！
        scheduler.standby();
        System.out.println("===============定时任务被暂停了=================");
        System.out.println("===============我处理好其他逻辑了，可以重启了=================");
        scheduler.start();

    }
}
