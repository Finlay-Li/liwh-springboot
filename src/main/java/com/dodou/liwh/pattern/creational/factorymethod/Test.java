package com.dodou.liwh.pattern.creational.factorymethod;


/**
 * @author: Finlay
 * @ClassName: Test
 * @Description:
 * @date: 2019-04-25 7:49 PM
 */
public class Test {
    public static void main(String[] args) {
        VideoFactory videoFactory = new PythonVideoFactory();
        VideoFactory videoFactory2 = new JavaVideoFactory();
        Video video = videoFactory.getVideo();
        video.produce();
    }
}
