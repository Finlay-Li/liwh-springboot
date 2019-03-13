package com.dodou.liwh.amqp.original.broadcast;

import com.dodou.liwh.amqp.original.MQConnectUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;

/**
 * @author: Lwh
 * @ClassName: Recv2
 * @Description:
 * @version: 1.0.0
 * @date: 2019-03-13 1:55 PM
 */
public class Recv2 {


    //消费队列
    private final static String QUEUE_NAME = "test_queue_work";
    //绑定交换机
    private final static String EXCHANGE_NAME = "test_exchange_fanout";

    public static void main(String[] args) throws IOException, InterruptedException {
        Connection connection = MQConnectUtil.getConnection();
        //拿到操纵者
        Channel channel = connection.createChannel();
        //声明消费队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //绑定交换机
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"");
        //定义工作模式
        channel.basicQos(1);
        //创建消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        //发布监听
        channel.basicConsume(QUEUE_NAME,false,consumer);
        //获取投递的消息
        while (true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            byte[] body = delivery.getBody();
            String message = body.toString();
            System.out.println(" [x] Received '" + message + "'");
            Thread.sleep(3000);
            //手动ack
            long tag = delivery.getEnvelope().getDeliveryTag();
            channel.basicAck(tag,false);
        }
    }
}
