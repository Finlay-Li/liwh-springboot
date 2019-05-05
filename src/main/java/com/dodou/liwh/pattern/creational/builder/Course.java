package com.dodou.liwh.pattern.creational.builder;

import lombok.Data;

/**
 * @author: Finlay
 * @ClassName: Course
 * @Description:
 * @date: 2019-05-03 6:44 PM
 */
@Data
public class Course {
    private String courseName;
    private String coursePPT;
    private String courseVideo;
    private String courseArticle;
    private String courseQA;

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", coursePPT='" + coursePPT + '\'' +
                ", courseVideo='" + courseVideo + '\'' +
                ", courseArticle='" + courseArticle + '\'' +
                ", courseQA='" + courseQA + '\'' +
                '}';
    }
}
