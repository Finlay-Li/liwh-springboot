package com.dodou.liwh.pattern.creational.abstractfactory;

/**
 * @author: Finlay
 * @ClassName: JavaArticle
 * @Description:
 * @date: 2019-04-27 5:12 PM
 */
public class JavaArticle extends Article {
    @Override
    public void produce() {
        System.out.println("编写Java课程手记");
    }
}
