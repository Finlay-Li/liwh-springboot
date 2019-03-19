package com.dodou.liwh.amqp.boot;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: Lwh
 * @ClassName: Receiver
 * @Description:
 * @version: 1.0.0
 * @date: 2019-03-19 6:50 PM
 */
@Component
@RabbitListener(queues = "hello")
public class Receiver {

    /*消费消息*/
    @RabbitHandler
    public void process(String msg) {
        System.out.println("Receiver消费消息:" + msg);
    }
}
