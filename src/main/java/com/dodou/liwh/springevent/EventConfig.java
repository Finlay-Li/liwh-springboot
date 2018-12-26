package com.dodou.liwh.springevent;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: Liwh
 * @ClassName: EventConfig
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-14 2:32 PM
 */
@Configurable
@ComponentScan("com.dodou.liwh.springevent")
public class EventConfig {

    public DemoPulisher getDemoPulisher() {

        return new DemoPulisher();
    }


}
