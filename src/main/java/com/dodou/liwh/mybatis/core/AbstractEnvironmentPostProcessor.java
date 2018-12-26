package com.dodou.liwh.mybatis.core;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

import java.util.Iterator;
import java.util.Map;

/**
 * @author: Liwh
 * @ClassName: AbstractEnvironmentPostProcessor
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-26 4:23 PM
 */
public class AbstractEnvironmentPostProcessor {
    private static final Logger log = LoggerFactory.getLogger(AbstractEnvironmentPostProcessor.class);
    protected final String PROPERTY_SOURCE_NAME = "defaultProperties";
    protected ResourceLoader resourceLoader = new DefaultResourceLoader();

    public AbstractEnvironmentPostProcessor() {
    }

    public void addCommonProperty(ConfigurableEnvironment environment) {
    }

    public void addProperty(MutablePropertySources propertySources, Map<String, Object> map) {
        MapPropertySource target = null;
        if (propertySources.contains(PROPERTY_SOURCE_NAME)) {
            PropertySource<?> propertySource = propertySources.get(PROPERTY_SOURCE_NAME);
            if (propertySource instanceof MapPropertySource) {
                target = (MapPropertySource) propertySource;
                Iterator<String> iterator = map.keySet().iterator();
                while (iterator.hasNext()) {
                    String var5 = iterator.next();
                    if (!target.containsProperty(var5)) {
                        target.getSource().put(var5, map.get(var5));
                    }
                }
            }
        }

        //第一次启动
        if (target == null) {
            target = new MapPropertySource(PROPERTY_SOURCE_NAME, map);
            log.info("DefaultProperties init ,name :{}", PROPERTY_SOURCE_NAME);
        }

        if (!propertySources.contains(PROPERTY_SOURCE_NAME)) {
            propertySources.addLast(target);
        }
    }
}
