package com.dodou.liwh.pattern.creational.singleton;

import java.io.Serializable;

/**
 * @author: Finlay
 * @ClassName: HungrySingleton
 * @Description: 优点：
 * 1. 很明显，写法简单多了
 * 2. 加载就创建，避免了多线程的问题
 * <p>
 * 缺点：
 * 1. 因为一上来就创建了，若我们用都不用，就会造成内存的浪费
 * @date: 2019-05-06 4:56 PM
 */
public class HungrySingleton implements Serializable {
    private static final long serialVersionUID = 2779448223525049323L;
    //final 修饰的变量，是不可变的，大家都知道
    //原因呢？是因为final 修饰的变量必须在类加载时就完成初始化
    private static final HungrySingleton instance;

    static {
        instance = new HungrySingleton();
    }

    public HungrySingleton() {
        //表明已经创建了
        if (instance != null) {
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }

    public static HungrySingleton getInstance() {
        return instance;
    }

    private Object readResolve() {
        return instance;
    }
}
