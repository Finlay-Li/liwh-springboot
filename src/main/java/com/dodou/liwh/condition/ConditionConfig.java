package com.dodou.liwh.condition;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * @author: Liwh
 * @ClassName: ConditionConfig
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-15 12:51 PM
 */
@Configurable
@ComponentScan("com.dodou.liwh.condition")
public class ConditionConfig {

    @Bean
    @Conditional(MacCondition.class)
    public CmdListService getMacCmdService() {
        return new MacCmdServiceImpl();
    }

    @Bean
    @Conditional(WindowsCondition.class)
    public CmdListService getWindowsCmdService() {
        return new WindowsCmdServiceImpl();
    }
}
