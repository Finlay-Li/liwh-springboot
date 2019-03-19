package com.dodou.liwh.amqp.original;


import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * @author: Lwh
 * @ClassName: MQConnectUtil
 * @Description:
 * @version: 1.0.0
 * @date: 2019-03-12 11:12 AM
 */
public class MQConnectUtil {

    public static Connection getConnection() throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setVirtualHost("develop");
        //develop这个虚拟服务器在guest账户下
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection connection = null;
        try {
            connection = factory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
