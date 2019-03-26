package com.dodou.liwh.ws.nettyws;

import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: Li Wen Hui
 * @ClassName: PriceHandler
 * @Description:
 * @version: 1.0.0
 * @date: 2019-03-26 6:04 PM
 */
@Component
public class PriceHandler {

    ExecutorService threadPool = Executors.newFixedThreadPool(1);

    @PostConstruct
    public void init() {
        Thread thread = new Thread(() -> {
            while (true) {
                CopyOnWriteArraySet<Channel> channels = WebSocketHandler.Channels;
                /*群发所有连接*/
                for (Channel channel : channels) {
                    try {
                        channel.writeAndFlush(new TextWebSocketFrame("netty ws push test"));
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        continue;
                    }
                }
            }
        });
        threadPool.submit(thread);
    }
}
