package com.dodou.liwh.mybatis.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dodou.liwh.mybatis.base.SuperServiceImpl;
import com.dodou.liwh.mybatis.dao.mapper.DepartmentMapper;
import com.dodou.liwh.mybatis.dao.model.Department;
import org.springframework.stereotype.Service;

/**
 * @author: Liwh
 * @ClassName: UserServiceImpl
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-21 3:29 PM
 */
@Service
public class DepartmentServiceImpl extends SuperServiceImpl<DepartmentMapper, Department> /*extends ServiceImpl<DepartmentMapper, Department>*/ implements DepartmentService {


}
