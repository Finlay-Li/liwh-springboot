package com.dodou.liwh.Java8;

/**
 * @author: Finlay
 * @ClassName: LambdaTester3
 * @Description:
 * @date: 2019-03-27 5:55 PM
 */
public class LambdaTester3 {

    public static void main(String[] args) {
        // 1.1使用匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world !");
            }
        }).start();

        // 1.2 lambda
        Thread thread = new Thread(() -> {
            //多行语句
            //使用{}包括
        });
        thread.start();
    }
}
