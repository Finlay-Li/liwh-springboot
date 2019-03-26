package com.dodou.liwh.ws.nettyws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yeauty.standard.ServerEndpointExporter;

/**
 * @author: Li Wen Hui
 * @ClassName: ServerEndpointExporter
 * @Description:
 * @version: 1.0.0
 * @date: 2019-03-26 5:06 PM
 */
@Configuration
public class WebSocketConfig {

    /*ws 服务端输出口:交给Spring IOC容器，表示要开启WebSocket功能*/
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        ServerEndpointExporter exporter = new ServerEndpointExporter();
        return exporter;
    }
}
