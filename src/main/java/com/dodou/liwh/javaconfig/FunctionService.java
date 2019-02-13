package com.dodou.liwh.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: Liwh
 * @ClassName: FunctionService
 * @Description: 功能类
 * @version: 1.0.0
 * @date: 2018-11-10 3:29 PM
 */
//@Component
public class FunctionService {

    public String sayHello() {
        return "hello:javaConfig!";
    }
    @Autowired
    private a a;
}
