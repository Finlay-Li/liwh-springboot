package com.dodou.liwh.mybatis.config;

import com.dodou.liwh.mybatis.core.AbstractEnvironmentPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;

/**
 * @author: Liwh
 * @ClassName: DefaultMybatisEnviromentPostProcessor
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-26 6:40 PM
 */
public class DefaultMybatisEnvironmentPostProcessor extends AbstractEnvironmentPostProcessor implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment configurableEnvironment, SpringApplication springApplication) {
        MutablePropertySources propertySources = configurableEnvironment.getPropertySources();
        HashMap<String, Object> map = new HashMap<>();
//      使用mybatis-p提供的方法时可不配置
        map.put("mybatis-plus.mapperLocations","classpath:/mybatis/**/*Mapper.xml");
        map.put("mybatis-plus.typeAliasesPackage","com.dodou.liwh.mybatis.dao.model,com.dodou.liwh.dao.model,com.dodou.liwh.quartz.dao.model");
        this.addProperty(propertySources,map);
    }
}
