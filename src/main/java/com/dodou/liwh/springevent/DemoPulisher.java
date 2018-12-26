package com.dodou.liwh.springevent;


import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: Liwh
 * @ClassName: DemoPulisher
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-14 11:47 AM
 */
public class DemoPulisher {
    //使用容器发布
    @Autowired
    ApplicationContext applicationContext;

    //通信方法--->设置msg
    public void pulisher(String msg) {
//        applicationContext.pushEvent( new DemoEvent(this,msg));
    }
}
