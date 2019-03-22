package com.dodou.liwh.amqp.boot.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Lwh
 * @ClassName: MqConfig
 * @Description:
 * @version: 1.0.0
 * @date: 2019-03-22 5:02 PM
 */
@Configuration
public class MqQueueConfig {
    @Bean
    public Queue helloQueue() {
        //默认是创建持久化队列
        return new Queue("hello");
    }


    /*消费者*/
    @Bean
    public Queue directQueue() {
        return new Queue("direct.que");
    }

    @Bean
    public Queue topicQueue() {
        // 参数1 name ：队列名
        // 参数2 durable ：是否持久化
        // 参数3 exclusive ：仅创建者可以使用的私有队列，断开后自动删除
        // 参数4 autoDelete : 当所有消费客户端连接断开后，是否自动删除队列
        return new Queue("topic.que",false,false,false);
    }
}
