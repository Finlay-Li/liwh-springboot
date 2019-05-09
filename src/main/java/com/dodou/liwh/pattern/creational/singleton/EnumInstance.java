package com.dodou.liwh.pattern.creational.singleton;

/**
 * @author: Finlay
 * @EnumName: EnumInstance
 * @Description: 单例枚举
 * @date: 2019-05-09 3:12 PM
 */
public enum EnumInstance {
    INSTANCE;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumInstance getInstance() {
        return INSTANCE;
    }
}
