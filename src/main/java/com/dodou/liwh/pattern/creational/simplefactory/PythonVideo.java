package com.dodou.liwh.pattern.creational.simplefactory;

/**
 * @author: Finlay
 * @ClassName: PythonVideo
 * @Description:
 * @date: 2019-04-25 7:49 PM
 */
public class PythonVideo extends Video{
    @Override
    void produce() {
        System.out.println("录制Python课程视频");
    }
}
