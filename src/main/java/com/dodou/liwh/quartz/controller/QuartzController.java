package com.dodou.liwh.quartz.controller;

import com.dodou.liwh.quartz.handler.JobHandler;
import com.dodou.liwh.quartz.support.JobResult;
import com.dodou.liwh.quartz.dao.model.ScheduleJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @author: Liwh
 * @ClassName: QuartzController
 * @Description:
 * @version: 1.0.0
 * @date: 2018-12-21 4:47 PM
 */
@Controller
@RequestMapping("/job")
public class QuartzController {

    @Autowired
    private JobHandler jobHandler;

    //访问job管理页面
    @GetMapping("/manager/dodou's.job/html")
    public String toJobPage() {
        return "job";
    }

    //获取全部Job
    @PostMapping("/list")
    @ResponseBody
    public JobResult getAllJob(String jobStatus, String jobName) {
        List<ScheduleJob> enableJob = jobHandler.getAllJob(jobStatus, jobName);
        return JobResult.ok().put("data", enableJob);
    }

    //查看一条Job
    @PostMapping("/get/by/id")
    @ResponseBody
    public JobResult getJobById(Long id) {
        ScheduleJob enableJob = jobHandler.getJobById(id);
        return JobResult.ok().put("data", enableJob);
    }

    //添加Job
    @PostMapping("/add")
    @ResponseBody
    public JobResult addJob(ScheduleJob job) {

        if (Objects.isNull(job)) {
            return JobResult.error("参数不能为空");
        }
        JobResult result = jobHandler.createScheduleJob(job);
        return result;
    }

    //更新Job,只能修改Cron表达式
    @PostMapping("/update")
    @ResponseBody
    public JobResult updateJob(ScheduleJob job) {
        if (Objects.isNull(job.getId())) {
            return JobResult.error("Id不能为空");
        }
        JobResult result =
                jobHandler.updateScheduleJob(job);
        return result;
    }

    //删除Job
    @PostMapping("/remove")
    @ResponseBody
    public JobResult removeJob(ScheduleJob job) {
        if (Objects.isNull(job.getId())) {
            return JobResult.error("Id不能为空");
        }
        JobResult result = jobHandler.deleteJob(job);
        return result;
    }

    //立即触发Job
    @PostMapping("/trigger")
    @ResponseBody
    public JobResult triggerJob(ScheduleJob job) {
        JobResult result = jobHandler.runJob(job);

        return result;
    }

    //暂停Job
    @PostMapping("/pause")
    @ResponseBody
    public JobResult pauseJob(ScheduleJob job) {
        JobResult result = jobHandler.pauseJob(job);

        return result;

    }

    //继续执行Job
    @PostMapping("/resume")
    @ResponseBody
    public JobResult resumeJob(ScheduleJob job) {
        JobResult result = jobHandler.resumeJob(job);

        return result;
    }

}
