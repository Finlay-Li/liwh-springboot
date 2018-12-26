package com.dodou.liwh.mybatis.dao.mapper;


import com.dodou.liwh.mybatis.base.SuperMapper;
import com.dodou.liwh.mybatis.dao.model.MpUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author: Liwh
 * @ClassName: UserMapper
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-23 3:38 PM
 */
public interface MpUserMapper extends SuperMapper<MpUser> {
    MpUser queryById(@Param("id") Long id);

}
