package com.song.nowcoder;

import java.util.Arrays;

/**
 * @author yuanpeng.song
 * @createTime 2021/1/25
 * @description 合并两个有序数组
 * Laughter is poison to fear.
 */
public class ANswer22 {
    /**
     * 给出两个有序的整数数组 和 ，请将数组 合并到数组 中，变成一个有序的数组
     * 注意：
     * 可以假设 数组有足够的空间存放 数组的元素， 和 中初始的元素数目分别为 和
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int A[], int m, int B[], int n) {
        System.arraycopy(B,0,A,n,m);
        Arrays.sort(A);
    }
}
