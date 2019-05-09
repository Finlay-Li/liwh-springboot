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


//        Class<LazySingleton> clazz = LazySingleton.class;
//        Constructor<LazySingleton> constructor = clazz.getDeclaredConstructor();
//        //打开私有权限
//        constructor.setAccessible(true);
//        LazySingleton newInstance = constructor.newInstance();
//
//        LazySingleton instance = LazySingleton.getInstance();
//        //比较
//        System.out.println(instance);
//        System.out.println(newInstance);
//        System.out.println(instance == newInstance);

//        //枚举反序列化破坏
//        EnumInstance instance = EnumInstance.getInstance();
//        ObjectOutputStream obs = new ObjectOutputStream(new FileOutputStream("singleton_file"));
//        obs.writeObject(instance);
//
//        File file = new File("singleton_file");
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
//        EnumInstance newInstance = (EnumInstance) ois.readObject();
        Class<EnumInstance> clazz = EnumInstance.class;
        //是有参构造器，jdk 1.8 枚举构造器修饰符改为protected
//        Constructor<EnumInstance> constructor = clazz.getDeclaredConstructor(String.class, int.class);
//        constructor.setAccessible(true);
//        EnumInstance newInstance = constructor.newInstance("Finlay", 666);
        EnumInstance newInstance = clazz.newInstance();
        EnumInstance instance = EnumInstance.getInstance();

        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);

    }
}
