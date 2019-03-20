package com.dodou.test;

import com.dodou.liwh.amqp.boot.direct.DirectSender;
import com.dodou.liwh.amqp.boot.hello.HelloSender;
import com.dodou.liwh.amqp.boot.topic.TopicSender;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: Lwh
 * @ClassName: MQTest
 * @Description:
 * @version: 1.0.0
 * @date: 2019-03-19 7:00 PM
 */
public class MQTest extends ApplicationTest {

    @Autowired
    HelloSender hello;

    @Autowired
    DirectSender directSender;
    @Autowired
    TopicSender topicSender;


    @Test
    public void send() {
        hello.send();
    }

    @Test
    public void direct() {
        directSender.send();
    }

    @Test
    public void topic() {
        topicSender.send();
    }
}
