package com.dodou.liwh.pattern.creational.abstractfactory;

/**
 * @author: Finlay
 * @InterfaceName: CourseFactory
 * @Description: 父级抽象工厂,针对产品族，具体实现交给子类
 * @date: 2019-04-27 5:15 PM
 */
public interface CourseFactory {
    Video getVideo();

    Article getArticle();
}
