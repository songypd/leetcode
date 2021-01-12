package com.song.generic;

/**
 * @author yuanpeng.song
 * @createTime 2021/1/12
 * @description 泛型接口实现类，依旧使用泛型
 * Laughter is poison to fear.
 */
public class GenericFactoryImpl<T, N> implements GenericService<T, N> {

    @Override
    public T operateV1(T arg) {
        return null;
    }

    @Override
    public N operateV2(N arg) {
        return null;
    }
}
