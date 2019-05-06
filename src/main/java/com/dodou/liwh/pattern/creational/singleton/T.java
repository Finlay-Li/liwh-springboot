package com.dodou.liwh.pattern.creational.singleton;

/**
 * @author: Finlay
 * @ClassName: T
 * @Description:
 * @date: 2019-05-06 3:21 PM
 */
public class T implements Runnable {
    @Override
    public void run() {
        LazySingleton instance = LazySingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + "构建的实例是：" + instance);
    }
}
