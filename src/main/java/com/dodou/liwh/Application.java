package com.dodou.liwh;

import com.dodou.liwh.propertiesconfig.AuthorSettings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author: Liwh
 * @ClassName: Application
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-08 10:32 AM
 */
@SpringBootApplication(exclude = {FreeMarkerAutoConfiguration.class})
@EnableConfigurationProperties(AuthorSettings.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
