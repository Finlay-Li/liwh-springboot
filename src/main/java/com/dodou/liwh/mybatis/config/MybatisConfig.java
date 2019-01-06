package com.dodou.liwh.mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * @author: Liwh
 * @ClassName: MybatisConfig
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-23 3:51 PM
 */
@Configuration
@MapperScan({"com.dodou.liwh.mybatis.dao.mapper", "com.dodou.liwh.quartz.dao.mapper"})
public class MybatisConfig {
    //更换为druid数据源
    @Bean
    @ConfigurationProperties("spring.datasource")
    @ConditionalOnMissingBean
    public DruidDataSource druidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager() {
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(druidDataSource());
        return manager;
    }

    //PaginationInterceptor
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }


}
