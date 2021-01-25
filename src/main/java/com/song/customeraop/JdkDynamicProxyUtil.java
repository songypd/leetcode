package com.song.customeraop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author yuanpeng.song
 * @createTime 2021/1/23
 * @description jdk动态代理
 * Laughter is poison to fear.
 */
public class JdkDynamicProxyUtil {


    public static <T> T newProxyInstance(T targetOBject, InvocationHandler handler) {
        ClassLoader classLoader = targetOBject.getClass().getClassLoader();
        Class<?>[] interfaces = targetOBject.getClass().getInterfaces();

        return (T) Proxy.newProxyInstance(classLoader, interfaces, handler);
    }
}

/***
 *  public static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
 */
