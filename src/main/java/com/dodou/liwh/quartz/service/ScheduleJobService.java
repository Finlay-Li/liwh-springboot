package com.dodou.liwh.quartz.service;

import com.dodou.liwh.mybatis.base.SuperService;
import com.dodou.liwh.quartz.dao.model.ScheduleJob;

import java.util.List;


/**
 * @author: Liwh
 * @ClassName: SchedulerService
 * @Description:
 * @version: 1.0.0
 * @date: 2018-12-21 8:25 PM
 */
public interface ScheduleJobService extends SuperService<ScheduleJob> {
    List<ScheduleJob> getAllJob(String jobStatus,String jobName);

    ScheduleJob getJobById(Long id);
}
