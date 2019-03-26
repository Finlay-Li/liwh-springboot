package com.dodou.liwh.ws.nettyws;

import io.netty.channel.Channel;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.timeout.IdleStateEvent;
import org.springframework.stereotype.Component;
import org.yeauty.annotation.*;
import org.yeauty.pojo.ParameterMap;
import org.yeauty.pojo.Session;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author: Li Wen Hui
 * @ClassName: WebSocketHandler
 * @Description: 以下均为WS生命周期的 【回调方法】
 * @version: 1.0.0
 * @date: 2019-03-26 5:10 PM
 */
@Component
@ServerEndpoint(prefix = "dodou.netty.websocket")
public class WebSocketHandler {

    /*存储WebSocket Channel，有了Channel就可以主动推送消息给客户端了*/
    public static CopyOnWriteArraySet<Channel> Channels = new CopyOnWriteArraySet<>();

    /*init:当有新的WebSocket连接进入时，对该方法进行回调*/
    @OnOpen
    public void onOpen(Session session, HttpHeaders headers, ParameterMap parameterMap) throws IOException {
        Channels.add(session.channel());
        String paramValue = parameterMap.getParameter("paramKey");
        System.out.println(paramValue);
    }

    /*注解@OnMessage是方法级别注解，当接收到字符串消息时，对该方法进行回调*/
    @OnMessage
    public void onMessage(Session session, String message) {
        System.out.println(message);
        /*服务器端返回的数据*/
        session.sendText("Hello Netty!");
    }

    /*当有WebSocket抛出异常时，对该方法进行回调*/
    @OnError
    public void onError(Session session, Throwable throwable) {
        Channels.remove(session.channel());
        throwable.printStackTrace();
    }

    /*当有WebSocket连接关闭时，对该方法进行回调*/
    @OnClose
    public void onClose(Session session) throws IOException {
        Channels.remove(session.channel());
        System.out.println("one connection closed");
    }

    /*当接收到二进制消息时，对该方法进行回调 */
    @OnBinary
    public void onBinary(Session session, byte[] bytes) {
        for (byte b : bytes) {
            System.out.println(b);
        }
        session.sendBinary(bytes);
    }

    /*当接收到Netty的事件时，对该方法进行回调*/
    @OnEvent
    public void onEvent(Session session, Object evt) {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            switch (idleStateEvent.state()) {
                case READER_IDLE:
                    System.out.println("read idle");
                    break;
                case WRITER_IDLE:
                    System.out.println("write idle");
                    break;
                case ALL_IDLE:
                    System.out.println("all idle");
                    break;
                default:
                    break;
            }
        }
    }

}
