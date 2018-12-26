package com.dodou.liwh.responsetype.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author liwh
 * @date 2018/8/27 19:34
 */
@Data
@XmlRootElement(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = -7851590832368268L;
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户密码
     */
    private String passWord;
}
