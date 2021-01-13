package com.song.generic;

import lombok.Data;

/**
 * @author yuanpeng.song
 * @createTime 2021/1/12
 * @description 泛型学习
 * Laughter is poison to fear.
 */
@Data
public class GenericDemo<T> {
    /**
     * 限制member的类型必须与类上的类型相同
     */
    private T member;

    public GenericDemo(T member) {
        this.member = member;
    }


    private static <E> void printClass(E[] array){
        System.out.println(array[0].getClass());
    }
}
/**
 * 泛型参数不支持非类型参数
 * 泛型参数不参加代码运行，在编译完成后就会被抹除,并不会保留到运行时
 *
 *
 * 能否在泛型里面使用具备继承关系的类
 * 1；使用通配符 ？ ，但是会使得泛型的类型检查失去意义
 * 2；给泛型加入上便捷 ？extends E
 *
 *泛型字母的含义
 * E-Element 在集合中使用，因为集合中存放的是元素
 * T-Type java 类
 * K-Key 键
 * V-value 值
 * */