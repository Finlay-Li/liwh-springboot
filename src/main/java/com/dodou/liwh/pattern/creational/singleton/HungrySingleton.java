package com.dodou.liwh.pattern.creational.singleton;

/**
 * @author: Finlay
 * @ClassName: HungrySingleton
 * @Description:
 * 优点：
 * 1. 很明显，写法简单多了
 * 2. 加载就创建，避免了多线程的问题
 *
 * 缺点：
 * 1. 因为一上来就创建了，若我们用都不用，就会造成内存的浪费
 * @date: 2019-05-06 4:56 PM
 */
public class HungrySingleton {
    //final 修饰的变量，是不可变的，大家都知道
    //原因呢？是因为final 修饰的变量必须在类加载时就完成初始化
    private final static HungrySingleton instance;

    static {
        instance = new HungrySingleton();
    }

    public HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
