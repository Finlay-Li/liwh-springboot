package com.dodou.liwh.pattern.creational.abstractfactory;

/**
 * @author: Finlay
 * @ClassName: JavaVideo
 * @Description:
 * @date: 2019-04-27 5:11 PM
 */
public class JavaVideo extends Video {
    @Override
    void produce() {
        System.out.println("录制Java课程视频");
    }
}
