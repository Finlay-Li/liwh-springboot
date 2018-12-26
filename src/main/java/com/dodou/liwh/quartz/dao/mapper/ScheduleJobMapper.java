package com.dodou.liwh.quartz.dao.mapper;

import com.dodou.liwh.mybatis.base.SuperMapper;
import com.dodou.liwh.quartz.dao.model.ScheduleJob;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author: Liwh
 * @interfaceName: ScheduleJobMapper
 * @Description:
 * @version: 1.0.0
 * @date: 2018-12-21 8:22 PM
 */
public interface ScheduleJobMapper extends SuperMapper<ScheduleJob> {
    List<ScheduleJob> getAllJob(@Param("jobStatus") String jobStatus, @Param("jobName") String jobName);

    ScheduleJob getJobById(@Param("id") Long id);
}
