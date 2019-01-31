package com.dodou.liwh.javaconfig;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: Liwh
 * @ClassName: UseFunctionService
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-10 3:31 PM
 */
@Data
public class UseFunctionService {

    @Autowired
    private FunctionService functionService;

    public String sayHello() {
        return functionService.sayHello();
    }
}
