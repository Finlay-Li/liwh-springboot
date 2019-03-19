package com.dodou.liwh.amqp.boot;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author: Lwh
 * @ClassName: RabbitConfig
 * @Description:
 * @version: 1.0.0
 * @date: 2019-03-19 6:53 PM
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue() {
        //默认是创建持久化队列
        Queue queue = new Queue("hello");
        return queue;
    }
}
