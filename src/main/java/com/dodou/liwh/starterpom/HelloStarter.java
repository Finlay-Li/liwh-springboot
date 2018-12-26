package com.dodou.liwh.starterpom;

import com.starter.liwh.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Liwh
 * @ClassName: HelloStarter
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-19 3:03 PM
 */
@RestController
public class HelloStarter {
    @Autowired
    HelloService helloService;

    @RequestMapping("/starter")
    public String starter() {
        return helloService.getMsg();
    }
}
