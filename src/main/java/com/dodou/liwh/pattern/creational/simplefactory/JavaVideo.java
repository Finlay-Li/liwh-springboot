package com.dodou.liwh.pattern.creational.simplefactory;

/**
 * @author: Finlay
 * @ClassName: JavaVideo
 * @Description:
 * @date: 2019-04-25 7:48 PM
 */
public class JavaVideo extends Video {
    @Override
    void produce() {
        System.out.println("录制Java课程视频");
    }
}
