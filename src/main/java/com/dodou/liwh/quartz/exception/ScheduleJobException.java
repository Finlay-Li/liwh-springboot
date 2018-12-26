package com.dodou.liwh.quartz.exception;

/**
 * @author: Liwh
 * @ClassName: ScheduleJobException
 * @Description:
 * @version: 1.0.0
 * @date: 2018-12-21 8:51 PM
 */
public class ScheduleJobException extends RuntimeException {

    public ScheduleJobException() {
    }

    public ScheduleJobException(String message) {
        super(message);
    }

    public ScheduleJobException(String message, Throwable cause) {
        super(message, cause);
    }
}
