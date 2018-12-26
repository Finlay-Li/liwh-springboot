package com.dodou.liwh.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface AppleColor {

    public enum Color {BLUE, ERD, GREEN}

    Color setColor() default Color.ERD;
}
