package com.dodou.liwh.pattern.creational.abstractfactory;

/**
 * @author: Finlay
 * @ClassName: JavaVideoFactory
 * @Description:
 * @date: 2019-04-27 5:21 PM
 */
public class JavaCourseFactory implements CourseFactory {
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }

    @Override
    public Article getArticle() {
        return new JavaArticle();
    }
}
