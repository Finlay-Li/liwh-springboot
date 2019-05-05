package com.dodou.liwh.pattern.creational.builder;

/**
 * @author: Finlay
 * @ClassName: CourseActualBuilder
 * @Description: 这种简单版的Builder是采用属性对象来接收赋值，再返回内部对象以完成builder
 * @date: 2019-05-03 6:55 PM
 */
public class CourseActualBuilder extends CourseBuilder {

    private Course course = new Course();

    @Override
    public void buildCourseName(String courseName) {
        this.course.setCourseName(courseName);
    }

    @Override
    public void buildCoursePPT(String coursePPT) {
        this.course.setCoursePPT(coursePPT);
    }

    @Override
    public void buildCourseVideo(String courseVideo) {
        this.course.setCourseVideo(courseVideo);
    }

    @Override
    public void buildCourseArticle(String courseArticle) {
        this.course.setCourseArticle(courseArticle);
    }

    @Override
    public void buildCourseQA(String courseQA) {
        this.course.setCourseQA(courseQA);
    }

    @Override
    public Course build() {
        return course;
    }
}
