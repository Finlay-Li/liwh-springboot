package com.dodou.liwh.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleToIntFunction;

/**
 * @author: Finlay
 * @ClassName: Java8Tester
 * @Description: 核心就是匿名内部类  ->  匿名方法
 * @date: 2019-03-27 3:27 PM
 */
public class LambdaTester {

    /*Lambda 表达式用在两种情况：
   1、自定义函数式接口，使用Lambda表达式来实现里面的逻辑，最后实际的传参调用->执行接口方法

   2、Lambda == 匿名内部类：常见的是调用集合的排序、遍历、实现Runnable接口等
   */
    public static void main(String[] args) {

//        可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
        MathOperation add = (int a, int b) -> a + b;
        MathOperation sub = (a, b) -> a - b;
//        可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
        DoubleToIntFunction mult = a -> (int) (2 * a);
//        可选的大括号：如果主体代码只有一个语句，就不需要使用大括号{}。

        MathOperation div = (int a, int b) -> a / b;
        System.out.println("10 + 5 = " + operate(10, 5, add));
        System.out.println("10 - 5 = " + operate(10, 5, sub));
        System.out.println("10 / 5 = " + operate(10, 5, div));
    }

    private static int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }


}
