package com.dodou.liwh.annotation.validation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Pattern;

/**
 * @author: Finlay
 * @AnnotationName: Email
 * @Description:
 * @date: 2019-03-28 1:55 PM
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE})
// 指定约束类是哪个
@Constraint(validatedBy = {Email.Validator.class})
public @interface Email {

    String EMAIL_REGEX = "^[\\w-]+(?:\\.[\\w-]+)*@(?:[\\w-]+\\.)+[a-zA-Z]{2,7}$";

    //这三个是强制实现的
    String message() default "{com.dodou.validation.Email.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    //自定义约束规则
    //ConstraintValidator接口使用了泛型，需要指定两个参数:第一个自定义注解类，第二个为需要校验的数据类型。
    public static class Validator implements ConstraintValidator<Email, String> {

        //初始化方法
        @Override
        public void initialize(Email email) {

        }

        //校验方法了。true为通过校验。
        @Override
        public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
            return Pattern.matches(EMAIL_REGEX, s);
        }
    }
}
