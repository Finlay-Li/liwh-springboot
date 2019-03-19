package com.dodou.liwh.amqp.original.worke;

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
 * @date: 2019-03-12 6:18 PM
 */
public class Recv2 {

    private final static String QUEUE_NAME = "test_queue_work";

    public static void main(String[] args) throws Exception, InterruptedException {
        //获取连接
        Connection connection = MQConnectUtil.getConnection();
        //获取通道
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //设置能者多劳,每次消费2条消息
        channel.basicQos(1);
        //声明消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        //消费者进行监听队列：false 表示关闭自动确认
        channel.basicConsume(QUEUE_NAME,false,consumer);
        //获取消息
        while (true){
            //获取生产者的投递
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            byte[] body = delivery.getBody();
            String message = new String(body);
            System.out.println(" [x] Received '" + message + "'");
            //模拟：能力弱的
            Thread.sleep(3000);
            //手动确认消费ACK
            long tag = delivery.getEnvelope().getDeliveryTag();
            //MQ返回的消费标识，具有相同传递标记的多条消息
            channel.basicAck(tag,false);
        }

    }
}
