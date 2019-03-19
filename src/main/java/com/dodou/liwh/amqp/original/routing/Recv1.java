package com.dodou.liwh.amqp.original.routing;

import com.dodou.liwh.amqp.original.MQConnectUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;

/**
 * @author: Lwh
 * @ClassName: Recv1
 * @Description:
 * @version: 1.0.0
 * @date: 2019-03-19 4:16 PM
 */
public class Recv1 {

    private final static String QUEUE_NAME = "test_queue_work";
    private final static String EXCHANGE_NAME = "test_exchange_direct";

    public static void main(String[] args) throws IOException, InterruptedException {
        //获取连接
        Connection connection = MQConnectUtil.getConnection();
        //获取通道
        Channel channel = connection.createChannel();
        //声明队列:        队列的名称,断言队列已经存在,持久,独占,其他属性
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //绑定交换机
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "key");
        //指定消费模式
        channel.basicQos(1);
        //定义消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        //监听队列，手动确认
        channel.basicConsume(QUEUE_NAME, false, consumer);
        //消费消息
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            byte[] body = delivery.getBody();
            String message = new String(body);
            System.out.println(" [x] Received '" + message + "'");
            long tag = delivery.getEnvelope().getDeliveryTag();
            //MQ返回的消费标识，具有相同传递标记的多条消息
            channel.basicAck(tag, false);
        }
    }

}
