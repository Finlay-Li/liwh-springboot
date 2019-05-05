package com.dodou.liwh.pattern.creational.builder;

/**
 * @author: Finlay
 * @ClassName: CourseBuilder
 * @Description: 特点：
 * 1. 构建的对象属性复杂，因此每一项属性都是独立赋值的
 * 2. 必定存在build（）构建出对象，方法名通常是build这是约定
 * @date: 2019-05-03 6:50 PM
 */
public abstract class CourseBuilder {
    public abstract void buildCourseName(String courseName);
    public abstract void buildCoursePPT(String coursePPT);
    public abstract void buildCourseVideo(String courseVideo);
    public abstract void buildCourseArticle(String courseArticle);
    public abstract void buildCourseQA(String courseQA);

    public abstract Course build();

}
