package com.dodou.liwh.amqp.boot;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: Lwh
 * @ClassName: Sender
 * @Description:
 * @version: 1.0.0
 * @date: 2019-03-19 6:45 PM
 */
@Component
public class Sender {

    //使用spring amqp提供的
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String msg = "hello boot 1.5.6 amqp" + new Date();
        System.out.println(msg);
//        rabbitTemplate.convertAndSend(msg);
        rabbitTemplate.convertAndSend("hello",msg);
    }
}
