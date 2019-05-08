package com.dodou.liwh.pattern.creational.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author: Finlay
 * @ClassName: Test
 * @Description:
 * @date: 2019-05-06 3:22 PM
 */
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        Thread thread1 = new Thread(new T());
//        Thread thread2 = new Thread(new T());
//
//        thread1.start();
//        thread2.start();
//
//        //写
//        HungrySingleton instance = HungrySingleton.getInstance();
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_file"));
//        oos.writeObject(instance);
//        //读
//        File file = new File("singleton_file");
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
//        HungrySingleton newInstance = (HungrySingleton) ois.readObject();
//        //比较
//        System.out.println(instance);
//        System.out.println(newInstance);
//        System.out.println(instance == newInstance);


        Class<LazySingleton> clazz = LazySingleton.class;
        Constructor<LazySingleton> constructor = clazz.getDeclaredConstructor();
        //打开私有权限
        constructor.setAccessible(true);
        LazySingleton newInstance = constructor.newInstance();

        LazySingleton instance = LazySingleton.getInstance();
        //比较
        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);
    }
}
