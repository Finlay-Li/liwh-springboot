package com.dodou.liwh.pattern.creational.builder;

/**
 * @author: Finlay
 * @ClassName: Test
 * @Description:
 * @date: 2019-05-04 9:11 PM
 */
public class Test {
    public static void main(String[] args) {
        //建造模式，核心就是：以内部属性，提供建造的对象
        //当然，这样写没有封闭性，我们也可以再构建一个中间类，如"导师经理人"去完成builder的方法
        CourseBuilder builder = new CourseActualBuilder();
//        builder.buildCourseName();
//        builder.buildCourseArticle();
//        builder.buildCourseVideo();
//        builder.buildCoursePPT();
//        builder.build();
        Coach coach = new Coach();
        coach.setCourseBuilder(builder);
        Course course = coach.makeCourse("Java设计模式精讲",
                "Java设计模式精讲PPT",
                "Java设计模式精讲视频",
                "Java设计模式精讲手记",
                "Java设计模式精讲问答");
        System.out.println(course);

    }
}
