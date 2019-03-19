package com.dodou.liwh.amqp.original.simple;

import com.dodou.liwh.amqp.original.MQConnectUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author: Lwh
 * @ClassName: Send
 * @Description:
 * @version: 1.0.0
 * @date: 2019-03-12 12:06 PM
 */
public class Send {
    private final static String QUEUE_NAME = "test_queue";

    public static void main(String[] args) throws Exception, TimeoutException {
        Connection connection = MQConnectUtil.getConnection();
        Channel channel = connection.createChannel();
        //队列的名称,断言队列已经存在,持久,独占,其他属性
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String msg = "Hello word 2";
        //发布到的交换机(名称)，routingKey，消息的其他属性，字节类型的数据
        channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
        channel.close();
        connection.close();
    }
}
