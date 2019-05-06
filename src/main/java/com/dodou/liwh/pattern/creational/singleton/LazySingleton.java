package com.dodou.liwh.pattern.creational.singleton;

/**
 * @author: Finlay
 * @ClassName: LazySingleton
 * @Description:
 * @date: 2019-05-06 3:02 PM
 */
public class LazySingleton {
    private LazySingleton() {
    }

    //定义一个对象属性，并提供一个创建其对象的方法，让开发者去调用创建
    private volatile static LazySingleton lazySingleton = null;

    //必须是静态的方法，否则开发者怎么调啊...
    public static LazySingleton getInstance() {

        if (lazySingleton == null) {
            //第1重保护
            synchronized (LazySingleton.class) {
                //第2重保护
                if (lazySingleton == null) {
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }
}
