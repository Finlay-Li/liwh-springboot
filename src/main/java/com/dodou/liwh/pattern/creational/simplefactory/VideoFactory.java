package com.dodou.liwh.pattern.creational.simplefactory;

/**
 * @author: Finlay
 * @ClassName: VideoFactory
 * @Description:
 * @date: 2019-04-25 7:51 PM
 */
public class VideoFactory {
    //处理的是String，每次有新的视频类时，都要跑进来改实现，违背了开闭原则
    public Video getVideo(String type) {
        if ("java".equalsIgnoreCase(type)) {
            return new JavaVideo();
        } else if ("python".equalsIgnoreCase(type)) {
            return new PythonVideo();
        }
        return null;
    }

    //处理的是Class，以反射去创建对应的对象，以遵守开闭原则
    public Video getVideo(Class type) {
        Video video = null;
        try {
            video = (Video) Class.forName(type.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return video;
    }
}
