package com.song.spring.aop.aspect;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yuanpeng.song
 * @createTime 2021/1/25
 * @description aspect ingo
 * Laughter is poison to fear.
 */
@AllArgsConstructor
@Getter
public class AspectInfo {
    private int order;
    private DefaultAspect defaultAspect;
}
