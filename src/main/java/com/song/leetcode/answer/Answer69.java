package com.song.leetcode.answer;

import java.util.Arrays;

/**
 * @author yuanpeng.song
 * @createTime 2021/1/21
 * @description 多数元素
 * Laughter is poison to fear.
 */
public class Answer69 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >>1];
    }
}
/**
 * 大于n/2的话，排序结果之后的结果中间下表的元素必然是目标元素
 *
 *
 *给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *  
 *
 * 进阶：
 *
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */