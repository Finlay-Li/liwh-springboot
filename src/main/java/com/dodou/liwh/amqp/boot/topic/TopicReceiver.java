package com.dodou.liwh.amqp.boot.topic;

import com.dodou.liwh.amqp.boot.ObjectUtils;
import com.dodou.liwh.amqp.boot.Hehe;
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
    public void rec(byte[] msg, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        try {
            channel.basicQos(1);
            Hehe hehe = ObjectUtils.getObjectFromBytes(msg, Hehe.class);
            System.out.println("消费者消费：" + hehe.toString());
            channel.basicAck(tag, false);
        } catch (Exception e) {
            try {
                // TODO 消费失败,那么我们可以进行容错处理,比如转移当前消息进入其它队列
//                channel.basicNack 与 channel.basicReject 的区别在于basicNack可以拒绝多条消息
//                而basicReject一次只能拒绝一条消息

//                tag:消息标识
//                false:是否批量.true:将一次性拒绝所有小于deliveryTag的消息
//                true:重新排队

                channel.basicNack(tag, false, true);
            } catch (IOException e1) {
                throw new RuntimeException(e1);
            }
        }

    }
}
