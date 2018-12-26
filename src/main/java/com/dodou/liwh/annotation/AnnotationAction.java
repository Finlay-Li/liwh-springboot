package com.dodou.liwh.annotation;

import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @author: Liwh
 * @ClassName: Apple
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-10 5:50 PM
 */
@Service
public class AnnotationAction {

    @AppleName(setName = "我吃苹果")
    public void eat() {
    }
}
