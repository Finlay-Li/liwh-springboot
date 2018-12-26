package com.dodou.liwh.springevent;

import lombok.Data;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @author: Liwh
 * @ClassName: DemoEvent
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-13 5:43 PM
 */
//1、定义事件
@Data
//@Component
public class DemoEvent extends ApplicationEvent {

    private String msg;

    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }
}
