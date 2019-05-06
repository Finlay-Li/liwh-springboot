package com.dodou.liwh.pattern.creational.builder.v2;

import com.google.common.collect.ImmutableSet;

/**
 * @author: Finlay
 * @ClassName: Test
 * @Description:
 * @date: 2019-05-05 5:51 PM
 */
public class Test {
    public static void main(String[] args) {
        /*//创建建造者:其是内部类
        Course.CourseBuilder builder = new Course.CourseBuilder();
        //通过建造者构建所需对象:建造者的属性是静态的
        Course.CourseBuilder courseBuilder = builder.buildCourseName("Java设计模式精讲").buildCoursePPT("Java设计模式精讲PPT").buildCourseVideo("Java设计模式精讲视频");
        Course course = courseBuilder.build();
        //查看创建的对象
        System.out.println(course);*/

        /*
        通过以上，能看出3个优点
        1、结构更清晰，合理。内部类，静态内部类，原来这样妙用
        2、需要什么属性就调什么方法，不需要的就不必定义
        3、链式的调用方式
        * */
        Course course = new Course.CourseBuilder().buildCourseName("Java设计模式精讲").buildCoursePPT("Java设计模式精讲PPT").buildCourseVideo("Java设计模式精讲视频").build();
        System.out.println(course);

        //应用了建造者模式的源码————Guava 的 不可变Set集合ImmutableSet
        ImmutableSet<String> set = ImmutableSet.<String>builder().add("a").add("b").build();
        System.out.println(set);
    }
}
