package com.dodou.liwh.pattern.creational.singleton;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: Finlay
 * @ClassName: ContainerSingleton
 * @Description:
 * 优点：
 * 容器思想，统一管理
 * 缺点：
 * 无法保证多线程安全
 * 所以：
 * 看情况选择
 * @date: 2019-05-10 6:01 PM
 */
public class ContainerSingleton {

    //容器
    private static ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String, Object>();

    //私有化构造器
    private ContainerSingleton() {

    }

    public static void putInstance(String key, Object instance) {
        if (key != null && instance != null) {
            if (!map.containsKey(key)) {
                map.put(key, instance);
            }
        }
    }

    public static Object getInstance(String key) {
        return map.get(key);
    }
}
