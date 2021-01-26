package com.song.spring.aop.executor;

import com.song.spring.aop.aspect.AspectInfo;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuanpeng.song
 * @createTime 2021/1/25
 * @description 切面处理类
 * Laughter is poison to fear.
 */
public class AspectListExecutor implements MethodInterceptor {

    private Class<?> targetClass;
    private List<AspectInfo> aspectInfos;

    public AspectListExecutor(Class<?> targetClass,List<AspectInfo> aspectInfos){
        this.targetClass = targetClass;
        this.aspectInfos = aspectInfos.stream().sorted(Comparator.comparingInt(AspectInfo::getOrder)).collect(Collectors.toList());
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //1；按照order的顺序，生序执行完所有的Aspect的Before方法
        //2；执行被代理类的方法
        //3；如果被代理方法正常返回，则按照order的顺序降序执行完所有的Aspect的afterReturning方法
        //4；如果被代理方法跑出异常，则按照order的顺序降序执行完所有Aspect的AfterThrowing方法

        return null;
    }
}
