package com.song.lambda;

import org.springframework.beans.factory.ObjectFactory;

/**
 * @author yuanpeng.song
 * @createTime 2021/1/21
 * @description 函数式编程中ObjectFactory的使用
 * Laughter is poison to fear.
 */
public class ObjectFactoryT {
    public static void main(String[] args) {
        objectFactory(1,()->{
            return doAdd(10,"ObjectFactoryT");
        });
    }

    private static Object doAdd(Integer target,String comment) {
        System.out.println(comment+"--------"+target++);
        return null;
    }

    private static void objectFactory(Integer origin, ObjectFactory<?> randomFactory){
        System.out.println(origin);
        randomFactory.getObject();
    }
}
/***
 * ObjectFactory
 * 定义一个工厂，该工厂在调用时可以返回Object实例（可能是共享的或独立的）。
 * 此接口通常用于封装通用工厂，
 * 该通用工厂在每次调用时返回某个目标对象的新实例（原型）。
 * 此接口与FactoryBean相似，但是后者的实现通常是在BeanFactory定义为SPI实例，
 * 而此类的实现通常是作为API馈送到其他bean（通过注入）。
 * 这样， getObject()方法具有不同的异常处
 */
