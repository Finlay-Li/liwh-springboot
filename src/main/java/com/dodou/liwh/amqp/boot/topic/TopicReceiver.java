package com.dodou.liwh.amqp.boot.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import com.rabbitmq.client.Channel;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author: Lwh
 * @ClassName: TopicReceiver
 * @Description:
 * @version: 1.0.0
 * @date: 2019-03-20 2:59 PM
 */
@Component
public class TopicReceiver {

    @RabbitListener(queues = "topic.que")
    @RabbitHandler
    /*msg : 消费的消息
     *channel : 当前操作通道
     *@Header : 可以获取到所有的头部信息
     * */
    public void rec(String msg, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        try {
            channel.basicQos(1);
            System.out.println("Receiver消费:队列是:topic.que" + ":消息:" + msg);
            channel.basicAck(tag, false);
        } catch (Exception e) {
            try {
                // 消费失败，重新发送消息
                channel.basicNack(tag, false, true);
            } catch (IOException e1) {
                throw new RuntimeException(e1);
            }
        }

    }
}
