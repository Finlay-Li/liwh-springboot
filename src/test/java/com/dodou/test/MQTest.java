package com.dodou.test;

import com.dodou.liwh.amqp.boot.Receiver;
import com.dodou.liwh.amqp.boot.Sender;
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
    Sender sender;
    @Autowired
    Receiver receiver;

    @Test
    public void send() {
        sender.send();
    }

}
