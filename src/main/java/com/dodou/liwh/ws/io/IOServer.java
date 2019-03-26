package com.dodou.liwh.ws.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: Lwh
 * @ClassName: IOServer
 * @Description:
 * @version: 1.0.0
 * @date: 2019-03-25 3:49 PM
 */
public class IOServer {

    public static void main(String[] args) throws Exception {

        //构建服务端对象
        ServerSocket serverSocket = new ServerSocket(8080);
        new Thread(() -> {
            while (true) {
                try {
                    //阻塞获取客户端连接,获取到一个连接就创建一个新的线程
                    Socket socket = serverSocket.accept();
                    new Thread(() -> {
                        try {
                            InputStream inputStream = socket.getInputStream();
                            byte[] bytes = new byte[1024];
                            int len;
                            // 按字节流方式读取数据到bytes再转换为String输出
                            while ((len = inputStream.read(bytes)) != -1) {
                                System.out.println(new String(bytes, 0, len));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
