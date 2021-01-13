package com.song.leetcode.answer;

import java.util.Arrays;

/**
 * @author yuanpeng.song
 * @createTime 2021/1/13
 * @description https://leetcode-cn.com/problems/single-number/
 * Laughter is poison to fear.
 */
public class Answer136 {

    public static void main(String[] args) {
//        int[] nums = {2,2,1};
        int[] nums = {-336, 513, -560, -481, -174, 101, -997, 40, -527, -784, -283, -336, 513, -560, -481, -174, 101, -997, 40, -527, -784, -283, 354};
        int i = new Answer136().singleNumber(nums);
        System.out.println(i);
    }

    /**
     * 长见识点；
     * 异或运算；二进制位上，相同为0，相异为一
     *
     * 1；任何数和 0 做异或运算，结果仍然是原来的数
     * 2；任何数和其自身做异或运算，结果是 0
     * 3；异或运算满足交换律和结合律，
     *
     * @param nums
     * @return
     */
    private int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single = single ^ num;
        }
        return single;
    }

    public int singleNumberV2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[nums.length - 2] != nums[nums.length - 1]) {
            return nums[nums.length - 1];
        }
        for (int i = 1; i < nums.length - 2; i++) {
            if (nums[i - 1] != nums[i] && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }


}
/**
 * 先排序，再遍历，最坏O(N)
 * <p>
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 时间复杂度为O(N)
 * 空间复杂度为O(1)
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
