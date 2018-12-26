package com.dodou.liwh.propertiesconfig;

import com.dodou.liwh.responsetype.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Liwh
 * @ClassName: UserController
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-08 10:31 AM
 */
@Controller
public class AssetController {

    @Autowired
    AuthorSettings authorSettings;

    @RequestMapping(value = "/author")
    @ResponseBody
    public List returnAuthor() {
        List<Object> list = new ArrayList<>();
        list.add(authorSettings.getName());
        list.add(authorSettings.getMoney());
        list.add(authorSettings.getAssets()[0]);
        list.add(authorSettings.getAssets()[2]);

        return list;
    }


}
