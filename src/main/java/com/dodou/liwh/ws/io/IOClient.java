package com.dodou.liwh.ws.io;

import java.net.Socket;
import java.util.Date;

/**
 * @author: Lwh
 * @ClassName: IOClient
 * @Description:
 * @version: 1.0.0
 * @date: 2019-03-25 4:15 PM
 */
public class IOClient {

    public static void main(String[] args) {
        new Thread(() -> {
            //获取一个Socket的对象
            try {
                Socket socket = new Socket("127.0.0.1", 8080);
                while (true) {
                    try {
                        //获取socket的输出流操作
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        socket.getOutputStream().flush();
                        Thread.sleep(2000);
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e) {
            }
        }).start();
    }

}
