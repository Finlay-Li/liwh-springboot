package com.dodou.liwh.quartz.support;

import lombok.Data;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author: Liwh
 * @ClassName: JobResult
 * @Description:
 * @version: 1.0.0
 * @date: 2018-12-21 5:17 PM
 */
@Data
public class JobResult extends HashMap<String, Object> {
    public JobResult() {
        put("code", 0);
    }

    public static JobResult ok() {
        return new JobResult();
    }

    public static JobResult ok(Objects msg) {
        JobResult jobResult = new JobResult();
        jobResult.put("msg", msg);
        return jobResult;
    }

    public static JobResult error(int code, String message) {
        JobResult jobResult = new JobResult();
        jobResult.put("code", code);
        jobResult.put("msg", message);
        return jobResult;
    }

    public static JobResult error(String message) {
        return error(500, message);
    }

    public static JobResult error() {
        return error(500, "");
    }

    @Override
    public JobResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
