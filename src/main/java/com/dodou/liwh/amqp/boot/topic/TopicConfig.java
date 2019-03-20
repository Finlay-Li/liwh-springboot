package com.dodou.liwh.amqp.boot.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Lwh
 * @ClassName: TopicConfig
 * @Description:
 * @version: 1.0.0
 * @date: 2019-03-20 3:05 PM
 */
@Configuration
public class TopicConfig {

    @Bean
    public TopicExchange topicExchange() {
        // 参数1 name ：交换机名称
        // 参数2 durable ：是否持久化
        // 参数3 autoDelete ：当所有消费客户端连接断开后，是否自动删除队列
        TopicExchange exchange = new TopicExchange("topic.ex", false, false);
        return exchange;
    }

    @Bean
    public Queue queue() {
        // 参数1 name ：队列名
        // 参数2 durable ：是否持久化
        // 参数3 exclusive ：仅创建者可以使用的私有队列，断开后自动删除
        // 参数4 autoDelete : 当所有消费客户端连接断开后，是否自动删除队列
        Queue queue = new Queue("topic.que",false,false,false);
        return queue;
    }

    @Bean
    public Binding binding(TopicExchange topicExchange, Queue queue) {
        //绑定消费规则
        Binding binding = BindingBuilder.bind(queue).to(topicExchange).with("topic.#");
        return binding;
    }
}
