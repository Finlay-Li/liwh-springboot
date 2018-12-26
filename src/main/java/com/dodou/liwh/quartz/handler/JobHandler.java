package com.dodou.liwh.quartz.handler;

import com.dodou.liwh.quartz.dao.model.ScheduleJob;
import com.dodou.liwh.quartz.exception.ScheduleJobException;
import com.dodou.liwh.quartz.service.ScheduleJobService;
import com.dodou.liwh.quartz.support.JobResult;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * @author: Liwh
 * @ClassName: JobHandler
 * @Description:
 * @version: 1.0.0
 * @date: 2018-12-21 8:35 PM
 */
@Component
public class JobHandler {

    @Autowired
    private ScheduleJobService scheduleJobService;
    @Autowired
    private Scheduler scheduler;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private void validateCronExpression(String cronExpression) {
        if (!CronExpression.isValidExpression(cronExpression)) {
            throw new ScheduleJobException("表达式无效！");
        }
    }

    //获取全部有效的Job
    public List<ScheduleJob> getAllJob(String jobStatus, String jobName) {
        return scheduleJobService.getAllJob(jobStatus, jobName);
    }

    //获取一个Job
    public ScheduleJob getJobById(Long id) {
        return scheduleJobService.getJobById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public JobResult createScheduleJob(ScheduleJob job) {
        job.setId(null);
        //1.获取Job的实现类
        try {
            validateCronExpression(job.getCronExpression());
            Class<?> clazz = Class.forName(job.getClassName());
            Class<?> aClass = clazz.newInstance().getClass();
            //2.创建JobDetail
            JobBuilder jobBuilder = JobBuilder.newJob((Class<? extends Job>) aClass);
            JobDetail jobDetail = jobBuilder.withIdentity(job.getJobName(), job.getJobGroup())
                    .withDescription(job.getDescription())
                    .build();
            //3.创建Trigger
            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
            CronTrigger cronTrigger = triggerBuilder.withIdentity(job.getTriggerName(), job.getTriggerGroup())
                    .withSchedule(CronScheduleBuilder.cronSchedule(job.getCronExpression()).withMisfireHandlingInstructionDoNothing())
                    .build();
            //4.把任务交给Scheduler:我们不马上运行：1 具体运行交给运行的方法 2 cron时间到了就会运行
            scheduler.scheduleJob(jobDetail, cronTrigger);
            scheduleJobService.saveOrUpdate(job);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return JobResult.error("创建失败:" + e.getMessage());
        }
        logger.info("Create schedule job {}-{} success", job.getJobGroup(), job.getJobName());
        return JobResult.ok();
    }

    @Transactional(rollbackFor = Exception.class)
    public JobResult updateScheduleJob(ScheduleJob job) {
        try {
            validateCronExpression(job.getCronExpression());

            //只能修改Cron表达式
            ScheduleJob scheduleJob = new ScheduleJob();
            scheduleJob.setId(job.getId());
            scheduleJob.setCronExpression(job.getCronExpression());

            scheduleJobService.updateById(scheduleJob);
//            int i = 1 / 0;
            //1.拿到Job的TriggerKey:更新 = 修改Trigger
            TriggerKey triggerKey = TriggerKey.triggerKey(job.getTriggerName(), job.getTriggerGroup());
            //2.构建新的CronTrigger
            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
            CronTrigger cronTrigger = triggerBuilder.withIdentity(job.getTriggerName(), job.getTriggerGroup())
                    .withSchedule(CronScheduleBuilder.cronSchedule(job.getCronExpression()).withMisfireHandlingInstructionDoNothing())
                    .build();
            //3.重新安排
            scheduler.rescheduleJob(triggerKey, cronTrigger);

        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return JobResult.error("修改失败:" + e.getMessage());
        }
        logger.info("Update schedule job {}-{} success", job.getJobGroup(), job.getJobName());
        return JobResult.ok();
    }

    @Transactional(rollbackFor = Exception.class)
    public JobResult deleteJob(ScheduleJob job) {
        try {
            scheduler.deleteJob(JobKey.jobKey(job.getJobName(), job.getJobGroup()));
            scheduleJobService.removeById(job);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return JobResult.error("删除失败:" + e.getMessage());
        }
        logger.info("Delete schedule job {}-{} success", job.getJobGroup(), job.getJobName());
        return JobResult.ok();
    }

    public JobResult runJob(ScheduleJob job) {
        try {
            scheduler.triggerJob(JobKey.jobKey(job.getJobName(), job.getJobGroup()));
        } catch (SchedulerException e) {
            return JobResult.error("触发失败:" + e.getMessage());
        }
        logger.info("Run schedule job {}-{} success", job.getJobGroup(), job.getJobName());
        return JobResult.ok();
    }

    public JobResult pauseJob(ScheduleJob job) {
        try {
            scheduler.pauseJob(JobKey.jobKey(job.getJobName(), job.getJobGroup()));
        } catch (SchedulerException e) {
            return JobResult.error("暂停失败:" + e.getMessage());
        }
        logger.info("Pause schedule job {}-{} success", job.getJobGroup(), job.getJobName());
        return JobResult.ok();
    }

    public JobResult resumeJob(ScheduleJob job) {
        try {
            scheduler.resumeJob(JobKey.jobKey(job.getJobName(), job.getJobGroup()));
        } catch (SchedulerException e) {
            return JobResult.error("恢复失败:" + e.getMessage());
        }
        logger.info("Resume schedule job {}-{} success", job.getJobGroup(), job.getJobName());
        return JobResult.ok();
    }

}
