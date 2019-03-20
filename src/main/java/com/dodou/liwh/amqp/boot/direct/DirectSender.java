package com.dodou.liwh.amqp.boot.direct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: Lwh
 * @ClassName: Send
 * @Description:
 * @version: 1.0.0
 * @date: 2019-03-20 10:38 AM
 */
@Component
public class DirectSender {

    @Autowired
    private AmqpTemplate amqpTemplate;
    private String RoutingKey = "direct.rout.key";
    private String EX_NAME = "direct.ex";
    private String msg = "交换机类型是：direct，用以支持RoutingKey";

    public void send() {
        amqpTemplate.convertAndSend(EX_NAME, RoutingKey, msg);
        System.out.println(msg);
    }

}
