package com.dodou.liwh.annotation;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: Liwh
 * @ClassName: AopConfig
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-12 3:01 PM
 */
@Configurable
@ComponentScan("com.dodou.liwh.annotation")
@EnableAspectJAutoProxy
public class AopConfig {

}


