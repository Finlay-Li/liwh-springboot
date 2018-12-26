package com.dodou.liwh.mybatis.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Liwh
 * @ClassName: DruidConfig
 * @Description: druid管理中心
 * @version: 1.0.0
 * @date: 2018-11-23 4:05 PM
 */
@Configuration
public class DruidConfig {

    //配置StatViewServlet
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        //com.alibaba.druid.support.http.StatViewServlet
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> initParams = new HashMap<>();
        initParams.put("loginUsername", "liwh");
        initParams.put("loginPassword", "dodou@liwh");
        initParams.put("allow", "");
        initParams.put("deny", "192.168.1.122");
        registrationBean.setInitParameters(initParams);
        return registrationBean;
    }

    //配置web的资源监控Filter,除此外的请求全进不去管理中心
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        //com.alibaba.druid.support.http.WebStatFilter
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new WebStatFilter());
        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        registrationBean.setInitParameters(initParams);
        registrationBean.setUrlPatterns(Arrays.asList("/*"));
        return registrationBean;
    }

}
