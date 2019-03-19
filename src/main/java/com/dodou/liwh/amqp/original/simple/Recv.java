package com.dodou.liwh.amqp.original.simple;

import com.dodou.liwh.amqp.original.MQConnectUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;

/**
 * @author: Lwh
 * @ClassName: Recv
 * @Description:
 * @version: 1.0.0
 * @date: 2019-03-12 12:06 PM
 */
public class Recv {
    private final static String QUEUE_NAME = "test_queue";

    public static void main(String[] args) throws Exception, InterruptedException {
        Connection connection = MQConnectUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(QUEUE_NAME, true, consumer);
        // 获取消息
        while (true) {
            //消费者获取传送的消息
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            //把接收的消息转换为String
            String message = new String(delivery.getBody());
            //咱自己看看
            System.out.println(" [x] Received '" + message + "'");

        }
    }
}
