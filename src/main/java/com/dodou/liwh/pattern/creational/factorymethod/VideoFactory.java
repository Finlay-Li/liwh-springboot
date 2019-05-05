package com.dodou.liwh.pattern.creational.factorymethod;

/**
 * @author: Finlay
 * @ClassName: VideoFactory
 * @Description:
 * @date: 2019-04-25 7:51 PM
 */
//用抽象类是可以有些属性和行为是我们可以预知的
public abstract class VideoFactory {
    //只负责定义规范，这样扩展就是开放的，具体的实现是关闭的
    abstract Video getVideo();
}
