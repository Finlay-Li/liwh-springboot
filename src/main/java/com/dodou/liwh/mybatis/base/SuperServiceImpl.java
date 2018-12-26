package com.dodou.liwh.mybatis.base;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author: Liwh
 * @ClassName: BaseServiceImpl
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-25 1:46 PM
 */
//@Service
public class SuperServiceImpl<M extends SuperMapper<T>,T> extends ServiceImpl<M,T> implements SuperService<T> {
}
