package com.dodou.liwh.annotation;

import java.lang.annotation.*;

/**
 * @author: Liwh
 * @ClassName: AppleName
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-10 5:39 PM
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Documented
public @interface AppleName {
    String name() default "";//default 表示参数的默认值

    String value() default "";//value（）是默认方法，调用时可以不写

}
