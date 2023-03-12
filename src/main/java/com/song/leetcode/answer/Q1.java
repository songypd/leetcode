package com.song.leetcode.answer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuanpeng.song
 * @createTime 2022/2/24
 * @description 两数之和
 * Laughter is poison to fear.
 */
public class Q1 {


    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 使用哈希表来解题 0(N),O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> targetMap = new HashMap();
        for (int i = 0;i<nums.length;i++){
            if (targetMap.containsKey(target-nums[i])){
                return new int[]{targetMap.get(target-nums[i]),i};
            }
            targetMap.put(nums[i],i);
        }
        return null;
    }
}
