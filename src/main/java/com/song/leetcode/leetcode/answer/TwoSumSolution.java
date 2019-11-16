package com.song.leetcode.leetcode.answer;

/**
 * @ClassName TwoSumSolution
 * @Description TODO
 * @Author songyp
 * @Date 2019-11-16 17:01
 * @Version 1.0.0
 */

import java.util.HashMap;
import java.util.Map;


public class TwoSumSolution {

    public static int[] twoSum(int[] nums, int target) {
        int pre = 0;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i <= nums.length - 1; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i <= nums.length - 1; i++) {
            if (map.containsKey(target - nums[i])&&map.get(target-nums[i])!= i) {
                pre = i;
                break;
            }
        }
        int[] res = {pre, map.get(target - nums[pre])};
        return res;
    }

    public static void main(String[]args){
        int[] nums = {3,2,4};
        int target = 6;
        twoSum(nums,target);
    }
}

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * res
 * 执行用时 :4 ms , 在所有 java 提交中击败了86.50% 的用户
 * 内存消耗 :36.6 MB, 在所有 java 提交中击败了 94.33%的用户
 */
