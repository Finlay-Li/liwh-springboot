package com.dodou.liwh.pattern.creational.simplefactory;

/**
 * @author: Finlay
 * @ClassName: Test
 * @Description:
 * @date: 2019-04-25 7:49 PM
 */
public class Test {
    public static void main(String[] args) {
//        VideoFactory videoFactory = new VideoFactory();
//        Video video = videoFactory.getVideo("java");
//        if (video == null) {
//            return;
//        }
//        video.produce();


        VideoFactory videoFactory = new VideoFactory();
        Video video = videoFactory.getVideo(JavaVideo.class);
        if(video == null){
            return;
        }
        video.produce();
    }
}
