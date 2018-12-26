package com.dodou.liwh.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author: Liwh
 * @ClassName: MacCondition
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-15 12:43 PM
 */
public class MacCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String property = conditionContext.getEnvironment().getProperty("os.name");
        String property2 = conditionContext.getEnvironment().getProperty("spring.application.name");
        return property.contains("Mac OS X");
    }
}
