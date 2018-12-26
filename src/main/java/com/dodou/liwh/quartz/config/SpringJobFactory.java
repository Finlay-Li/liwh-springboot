package com.dodou.liwh.quartz.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * @author: Liwh
 * @ClassName: SpringJobFactory
 * @Description: 解决SchedulerFactoryBean中JobFactory：Job newJob(TriggerFiredBundle var1, Scheduler var2) throws SchedulerException;
 *               所产生的Job无法引用Spring容器中bean（null）问题
 * @version: 1.0.0
 * @date: 2018-12-21 3:57 PM
 */
@Component
public class SpringJobFactory extends AdaptableJobFactory {
    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object jobInstance = super.createJobInstance(bundle);
        //把Job也交给Spring来管理
        autowireCapableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}
