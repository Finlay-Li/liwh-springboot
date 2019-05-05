package com.dodou.liwh.pattern.creational.factorymethod;

/**
 * @author: Finlay
 * @ClassName: JavaVideoFactory
 * @Description:
 * @date: 2019-04-25 9:08 PM
 */
public class JavaVideoFactory extends VideoFactory {
    @Override
    Video getVideo() {
        return new JavaVideo();
    }
}
