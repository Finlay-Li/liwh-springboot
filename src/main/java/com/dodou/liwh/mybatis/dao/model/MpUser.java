package com.dodou.liwh.mybatis.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author: Liwh
 * @ClassName: User
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-20 7:02 PM
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("d_user")
public class MpUser {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("name")
    private String name;
    @TableField("age")
    private Integer age;
    @TableField("user_email")
    private String userEmail;
}

