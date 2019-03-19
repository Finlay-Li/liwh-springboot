package com.dodou.liwh.amqp.original.worke;

import com.dodou.liwh.amqp.original.MQConnectUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @author: Lwh
 * @ClassName: Sent
 * @Description:
 * @version: 1.0.0
 * @date: 2019-03-12 6:07 PM
 */
public class Send {

    private final static String QUEUE_NAME = "test_queue_work";

    public static void main(String[] args) throws Exception, InterruptedException {
        //获取连接
        Connection connection = MQConnectUtil.getConnection();
        //获取通道
        Channel channel = connection.createChannel();
        //声明队列:        队列的名称,断言队列已经存在,持久,独占,其他属性
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //发布消息:        发布到的交换机(名称)，routingKey，消息的其他属性，字节类型的数据
        for (int i = 0; i < 100; i++) {
            // 消息内容
            String message = "work message " + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [" + i + "] Sent '" + message + "'");
            Thread.sleep(i * 10);
        }
        //关闭连接
        channel.close();
        connection.close();
    }

}
