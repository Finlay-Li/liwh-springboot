package com.dodou.liwh.amqp.boot;

import java.io.*;
import java.util.Objects;

/**
 * @Description:
 * @Version: V1.0.0
 * @Date: 2019/2/14 17:36
 */
public class ObjectUtils {

    /**
     * 对象转换成字节数组
     * @param obj   对象
     * @return      字节数组
     * @throws Exception
     */
    public static byte[] getBytesFromObject(Serializable obj) throws Exception {
        if (Objects.isNull(obj)) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(obj);
        return byteArrayOutputStream.toByteArray();
    }

    /**
     * 字节数组转换成对象
     * @param bytes     字节数组
     * @param clazz     class
     * @param <T>       对象泛型
     * @return          对象
     * @throws Exception
     */
    public static <T> T getObjectFromBytes(byte[] bytes,Class<T> clazz) throws Exception {
        if (bytes == null || bytes.length == 0) {
            return null;
        }

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Object obj = objectInputStream.readObject();
        return clazz.cast(obj);
    }

}
