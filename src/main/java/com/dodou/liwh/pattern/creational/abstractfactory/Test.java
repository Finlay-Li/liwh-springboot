package com.dodou.liwh.pattern.creational.abstractfactory;

/**
 * @author: Finlay
 * @ClassName: Test
 * @Description:
 * @date: 2019-04-27 5:34 PM
 */
public class Test {
    public static void main(String[] args) {
        //要创建Java 课程这个产品族的对象，并完成相关功能
        CourseFactory courseFactory = new JavaCourseFactory();
        Video video = courseFactory.getVideo();
        Article article = courseFactory.getArticle();
        //完成相关功能
        video.produce();
        article.produce();
    }
}
