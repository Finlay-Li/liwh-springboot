package com.dodou.liwh.amqp.boot.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: Lwh
 * @ClassName: Receiver
 * @Description:
 * @version: 1.0.0
 * @date: 2019-03-20 10:48 AM
 */
@Component
@RabbitListener(queues = "direct.que")
public class DirectReceiver {

    @RabbitHandler
    public void consume(String msg) {
        System.out.println("Receiver消费:队列是:direct.que" + ":消息:" + msg);
    }
}
