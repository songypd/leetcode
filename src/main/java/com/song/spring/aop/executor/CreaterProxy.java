package com.song.spring.aop.executor;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @author yuanpeng.song
 * @createTime 2021/1/25
 * @description 创建代理
 * Laughter is poison to fear.
 */
public class CreaterProxy {

    /**
     * 创建动态代理对象并返回
     *
     * @param targetClass 被代理的对象
     * @param methodInterceptor 方法拦截器
     * @return
     */
    public static Object createProxy(Class<?> targetClass, MethodInterceptor methodInterceptor) {
        return Enhancer.create(targetClass, methodInterceptor);
    }
}
