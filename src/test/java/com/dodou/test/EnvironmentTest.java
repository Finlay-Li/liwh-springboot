package com.dodou.test;

import com.dodou.liwh.Application;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @author: Liwh
 * @ClassName: Environment
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-15 12:32 PM
 */
public class EnvironmentTest extends ApplicationTest {

    @Test
    public void macName() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        Environment environment = context.getEnvironment();
        System.out.println(environment.getProperty("os.name"));
    }

}
