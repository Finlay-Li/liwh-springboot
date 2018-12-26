package com.dodou.liwh.springevent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author: Liwh
 * @ClassName: DemoApplicationListener
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-14 11:41 AM
 */
//@Component
public class DemoApplicationListener implements ApplicationListener<DemoEvent> {
    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        System.out.println("触发了发布事件：ApplicationListener监听启动————>");
        System.out.println("DemoEvent通信————>" + demoEvent.getMsg());
    }
}
