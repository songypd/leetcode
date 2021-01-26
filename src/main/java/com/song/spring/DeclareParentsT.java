package com.song.spring;

import com.song.listener.TestListener;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * @author yuanpeng.song
 * @createTime 2021/1/23
 * @description declareParents的测试类
 * Laughter is poison to fear.
 */

public class DeclareParentsT {

    @DeclareParents(value = "testListener",defaultImpl =com.song.listener.TestListener.class)
    private TestListener testListener;
}
