package com.dodou.liwh.amqp.boot.topic;

import com.dodou.liwh.amqp.boot.ObjectUtils;
import com.dodou.liwh.amqp.boot.Hehe;
import com.dodou.liwh.amqp.boot.Hei;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

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

    public void send() throws Exception {
        Hehe hehe = new Hehe();
        Hei hei = new Hei();
        hei.setNum(BigDecimal.ONE);
        hehe.setO(hei);
        hehe.setS("byte");
        //对象一定要转完再发，否则消费时报错：无法转换对象
        byte[] bytes = ObjectUtils.getBytesFromObject(hehe);
        amqpTemplate.convertAndSend(TOPIC_EX, RoutingKey, bytes);
        System.out.println(msg);
    }
}
