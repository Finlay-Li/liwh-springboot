package com.dodou.liwh.quartz.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Liwh
 * @ClassName: ScheduleJob
 * @Description: Job对象
 * @version: 1.0.0
 * @date: 2018-12-21 5:51 PM
 */
@Data
@TableName("QRTZ_SCHEDULE_JOB")
public class ScheduleJob implements Serializable {


    private static final long serialVersionUID = 5385290811685377718L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    //job全类名
    @TableField("class_name")
    private String className;

    //cron表达式
    @TableField("cron_expression")
    private String cronExpression;

    //job名字
    @TableField("job_name")
    private String jobName;

    //job组
    @TableField("job_group")
    private String jobGroup;

    //触发器名字
    @TableField("trigger_name")
    private String triggerName;

    //触发器组
    @TableField("trigger_group")
    private String triggerGroup;

    //1 等待执行 WAITING 2 正常执行 ACQUIRED 3 暂停执行 PAUSED 4 任务阻塞 BLOCKED 5 任务错误 ERROR
    @TableField(exist = false)
    private String jobStatus;

    //Job任务详情
    @TableField("description")
    private String description;

}
