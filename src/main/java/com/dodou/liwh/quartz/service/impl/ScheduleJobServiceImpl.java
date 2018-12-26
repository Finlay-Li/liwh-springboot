package com.dodou.liwh.quartz.service.impl;

import com.dodou.liwh.mybatis.base.SuperServiceImpl;
import com.dodou.liwh.quartz.dao.mapper.ScheduleJobMapper;
import com.dodou.liwh.quartz.dao.model.ScheduleJob;
import com.dodou.liwh.quartz.service.ScheduleJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author: Liwh
 * @ClassName: SchedulerServiceImpl
 * @Description:
 * @version: 1.0.0
 * @date: 2018-12-21 8:26 PM
 */
@Service
public class ScheduleJobServiceImpl extends SuperServiceImpl<ScheduleJobMapper, ScheduleJob> implements ScheduleJobService {

    @Autowired
    private ScheduleJobMapper scheduleJobMapper;

    @Override
    public List<ScheduleJob> getAllJob(String jobStatus,String jobName) {
        return scheduleJobMapper.getAllJob(jobStatus,jobName);
    }

    @Override
    public ScheduleJob getJobById(Long id) {
        return scheduleJobMapper.getJobById(id);
    }
}
