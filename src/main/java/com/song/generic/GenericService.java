package com.song.generic;

/**
 * @author yuanpeng.song
 * @createTime 2021/1/12
 * @description 泛型接口
 * Laughter is poison to fear.
 */
public interface GenericService<T, N> {
    T operateV1(T arg);

    N operateV2(N arg);
}
