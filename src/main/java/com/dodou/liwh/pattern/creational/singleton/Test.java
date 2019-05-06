package com.dodou.liwh.pattern.creational.singleton;

/**
 * @author: Finlay
 * @ClassName: Test
 * @Description:
 * @date: 2019-05-06 3:22 PM
 */
public class Test {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new T());
        Thread thread2 = new Thread(new T());

        thread1.start();
        thread2.start();
    }
}
