package com.song.spring.aop.aspect;

import java.lang.reflect.Method;

/**
 * @author yuanpeng.song
 * @createTime 2021/1/25
 * @description 默认拦截方式
 * Laughter is poison to fear.
 */
public abstract class DefaultAspect {

    /**
     * @param targetClass
     * @param method
     * @param args
     */
    public void before(Class<?> targetClass, Method method, Object[] args) {

    }

    /**
     * @param targetClass
     * @param method
     * @param args
     * @param value
     * @return
     */
    public Object after(Class<?> targetClass, Method method, Object[] args, Object value) throws Throwable {
        return value;
    }

    /**
     * @param targetClass
     * @param method
     * @param args
     * @param ex
     * @throws Exception
     */
    public void afterThrowing(Class<?> targetClass, Method method, Object[] args, Throwable ex) throws Throwable {
    }
}
