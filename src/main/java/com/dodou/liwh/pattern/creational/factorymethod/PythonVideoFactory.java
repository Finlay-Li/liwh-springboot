package com.dodou.liwh.pattern.creational.factorymethod;

/**
 * @author: Finlay
 * @ClassName: PythonVideoFactory
 * @Description:
 * @date: 2019-04-25 9:09 PM
 */
public class PythonVideoFactory extends VideoFactory {
    @Override
    Video getVideo() {
        return new PythonVideo();
    }
}
