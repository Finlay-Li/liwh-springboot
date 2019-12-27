package com.dodou.liwh.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Service;

/**
 * @author: Liwh
 * @ClassName: LinuxCondition
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-15 12:00 PM
 */
public class WindowsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment = conditionContext.getEnvironment();
        String property = environment.getProperty("os.name");
        return property.contains("Windows");
    }
}
