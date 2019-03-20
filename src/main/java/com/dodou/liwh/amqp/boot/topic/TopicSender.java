package com.dodou.liwh.amqp.boot.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: Lwh
 * @ClassName: TopicSender
 * @Description:
 * @version: 1.0.0
 * @date: 2019-03-20 2:51 PM
 */
@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate amqpTemplate;
    private String TOPIC_EX = "topic.ex";
    //生产者的发送RoutingKey
    private String RoutingKey = "topic.hello.fast";
    private String msg = "交换机类型是：topic，模糊匹配RoutingKey";

    public void send() {
        amqpTemplate.convertAndSend(TOPIC_EX, RoutingKey, msg);
        System.out.println(msg);
    }
}
