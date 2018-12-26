package com.dodou.liwh.mybatis.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dodou.liwh.mybatis.base.SuperServiceImpl;
import com.dodou.liwh.mybatis.dao.mapper.DepartmentMapper;
import com.dodou.liwh.mybatis.dao.mapper.MpUserMapper;
import com.dodou.liwh.mybatis.dao.model.Department;
import com.dodou.liwh.mybatis.dao.model.MpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Liwh
 * @ClassName: UserServiceImpl
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-21 3:29 PM
 */
@Service
public class MpUserServiceImpl extends SuperServiceImpl<MpUserMapper, MpUser> /*extends ServiceImpl<MpUserMapper, MpUser>*/ implements MpUserService {

    @Autowired
    MpUserMapper mpUserMapper;
    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public MpUser queryById(Long id) {
        return mpUserMapper.queryById(id);
    }

    @Override
    public Page queryUserByPage(Integer current, Integer size) {
        Page<MpUser> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        page.setDesc("id");
        List<MpUser> list = mpUserMapper.selectPageVo(page);
        page.setRecords(list);
        return page;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insterTransactional() {
        MpUser one = new MpUser();
        one.setName("one");
        one.setUserEmail("one@qq.com");
        mpUserMapper.insert(one);
//        int i = 0;
//        int ex = 1 % i;
        Department department = new Department();
        department.setDepartmentName("one");
        departmentMapper.insert(department);
    }

}
