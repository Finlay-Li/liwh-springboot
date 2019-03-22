package com.dodou.liwh.amqp.boot.direct;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Lwh
 * @ClassName: RabbitConfig
 * @Description:
 * @version: 1.0.0
 * @date: 2019-03-20 10:52 AM
 */
@Configuration
public class DirectConfig {

    /*生产者*/
    @Bean
    DirectExchange directExchange() {
        DirectExchange direct_ex = new DirectExchange("direct.ex");
        return direct_ex;
    }

    /*队列绑定交换机：Boot自动绑定，因为一个模型只有一个配置类：DirectConfig是不能同名的*/
    @Bean
    Binding binding(DirectExchange directExchange, Queue directQueue) {
        Binding binding = BindingBuilder.bind(directQueue).to(directExchange).with("direct.rout.key");
        return binding;
    }
}
