package com.dodou.liwh.mybatis.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dodou.liwh.mybatis.base.SuperService;
import com.dodou.liwh.mybatis.dao.model.MpUser;

/**
 * @author: Liwh
 * @interfaceName: UserService
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-21 3:28 PM
 */
public interface MpUserService extends SuperService<MpUser> /*extends IService<MpUser>*/ {
    MpUser queryById(Long id);

    Page queryUserByPage(Integer current, Integer size);

    void insterTransactional();
}
