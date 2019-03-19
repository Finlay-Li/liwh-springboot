package com.dodou.liwh.amqp.original.routing;

import com.dodou.liwh.amqp.original.MQConnectUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @author: Lwh
 * @ClassName: Send
 * @Description:
 * @version: 1.0.0
 * @date: 2019-03-12 8:17 PM
 */
public class Send {

    private final static String EXCHANGE_NAME = "test_exchange_direct";

    public static void main(String[] args) throws IOException, InterruptedException {
        //获取连接
        Connection connection = MQConnectUtil.getConnection();
        //获取通道
        Channel channel = connection.createChannel();
        //声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        //发布消息到交换机：指定rout key
        //发布到的交换机(名称)，routingKey，消息的其他属性，字节类型的数据
        for (int i = 0; i < 100; i++) {
            //定义消息
            String message = "Hello exchange direct!" + i;
            channel.basicPublish(EXCHANGE_NAME, "key", null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
            Thread.sleep(2000);
        }
        channel.close();
        connection.close();

    }
}
