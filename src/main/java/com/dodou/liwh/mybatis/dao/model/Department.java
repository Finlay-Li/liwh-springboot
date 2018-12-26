package com.dodou.liwh.mybatis.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: Liwh
 * @ClassName: Department
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-27 10:23 PM
 */
@Data
@TableName("d_department")
public class Department {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField("departmentName")
    private String departmentName;
}
