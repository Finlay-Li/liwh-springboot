package com.dodou.test;

import com.dodou.liwh.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: Liwh
 * @ClassName: ApplicationTest
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-15 12:22 PM
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("unit")
@SpringBootTest(classes = Application.class)
public class ApplicationTest {
}
