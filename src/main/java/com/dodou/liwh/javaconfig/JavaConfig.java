package com.dodou.liwh.javaconfig;

import com.dodou.liwh.javaconfig.FunctionService;
import com.dodou.liwh.javaconfig.UseFunctionService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * @author: Liwh
 * @ClassName: JavaConfig
 * @Description: 测试javaconfig的方式
 * @version: 1.0.0
 * @date: 2018-11-10 3:36 PM
 */
@Configurable
public class JavaConfig {
    @Bean
    public FunctionService functionService() {
        return new FunctionService();
    }

    @Bean
    public UseFunctionService useFunctionService() {
        UseFunctionService useFunctionService = new UseFunctionService();
//        useFunctionService.setFunctionService(functionService());
        return useFunctionService;
    }

    @Bean
    a a() {
        return new a();
    }
}
