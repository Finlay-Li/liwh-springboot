package com.dodou.liwh.quartz.config;

import org.quartz.Scheduler;
import org.quartz.ee.servlet.QuartzInitializerListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.util.Properties;

/**
 * @author: Liwh
 * @ClassName: SchedulerConfig
 * @Description:
 * @version: 1.0.0
 * @date: 2018-12-21 3:57 PM
 */
@Configuration
public class SchedulerConfig {

    @Autowired
    private SpringJobFactory springJobFactory;

    //读取我们的quartz.properties，创建SchedulerFactory
    @Bean("schedulerFactory")
    public SchedulerFactoryBean schedulerFactory() throws IOException {
        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
        schedulerFactory.setQuartzProperties(quartzProperties());
        schedulerFactory.setJobFactory(springJobFactory);
        return schedulerFactory;
    }

    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        //在quartz.properties中的属性被读取并注入后再初始化对象
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }

    //初始化任务监听器
    @Bean
    public QuartzInitializerListener executorListener() {
        return new QuartzInitializerListener();
    }

    //工厂模式获取Scheduler
    @Bean
    public Scheduler scheduler() throws IOException {
        Scheduler scheduler = schedulerFactory().getScheduler();
        return scheduler;
    }

}
