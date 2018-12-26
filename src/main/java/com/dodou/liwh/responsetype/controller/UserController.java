package com.dodou.liwh.responsetype.controller;

import com.dodou.liwh.responsetype.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: Liwh
 * @ClassName: UserController
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-08 10:31 AM
 */
@Controller
public class UserController {

    @RequestMapping(value = "/source")
    public String mvcSource() {
        return "mvcSource";
    }

    @RequestMapping(value = "/json", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public User returnJson() {
        User user = new User();
        user.setId(1);
        user.setPassWord("111");
        user.setUserName("one");

        return user;
    }

    //ViewResolver无法解析: 大体指，无法解析xxx.xml
    @RequestMapping(value = "xml", produces = {"application/xml;charset=utf-8"})
    @ResponseBody
    public User returnXml() {
        User user = new User();
        user.setId(2);
        user.setPassWord("222");
        user.setUserName("two");

        return user;
    }
}
