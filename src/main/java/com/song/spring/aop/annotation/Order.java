package com.song.spring.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @author yuanpeng.song
 * @createTime 2021/1/23
 * @description jdk动态代理
 * Laughter is poison to fear.
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Order {
    /**
     * 值越小，优先级越高
     *
     * @return
     */
    int value();
}
