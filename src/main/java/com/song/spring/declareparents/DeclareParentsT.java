package com.song.spring.declareparents;

import org.aspectj.lang.annotation.DeclareParents;

/**
 * @author yuanpeng.song
 * @createTime 2021/1/23
 * @description declareParents的测试类
 * Laughter is poison to fear.
 */

public class DeclareParentsT {

    @DeclareParents(value = "com.song.listener.*",defaultImpl=com.song.spring.declareparents.ListenServiceImpl.class)
    private ListenService listenService;
}
