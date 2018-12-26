package com.dodou.liwh.condition;

import org.springframework.stereotype.Service;

/**
 * @author: Liwh
 * @ClassName: WindowsCmdServiceImpl
 * @Description:
 * @version: 1.0.0
 * @date: 2018-11-15 12:48 PM
 */
public class WindowsCmdServiceImpl implements CmdListService {
    @Override
    public void cmd() {
        System.out.println("windows:dir");
    }
}
