package com.song.theway2glory;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName answer1
 * @Description Valar Morghulis.Valar Dohaeris
 * @Author songyp
 * @Date 2020-09-10 15:01
 */
public class Answer_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> indexMap = new HashMap<>();
        //只会对应一个答案，也就是不会出现相同的数字，所以可以保证唯一 key
        for (int i = 0; i < nums.length; i++) {
            indexMap.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++){
            if (indexMap.keySet().contains(target-nums[i]) && (i != indexMap.get(target-nums[i]))){

                int []res = {i,indexMap.get(target-nums[i])};
                return res;
            }
        }

        return null;
    }
}
/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 *  
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
