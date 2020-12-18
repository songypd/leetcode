package com.song.leetcode.answer;

/**
 * @ClassName Answer14
 * @Description Valar Morghulis.Valar Dohaeris
 * @Author songyp
 * @Date 2020-12-17 12:20
 */
public class Answer14 {
    /**
     * 纵向扫描。
     * 纵向扫描时，从前往后遍历所有字符串的每一列，比较相同列上的字符是否相同，
     * 如果相同则继续对下一列进行比较，如果不相同则当前列不再属于公共前缀，
     * 当前列之前的部分为最长公共前缀。
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        if (strs.length == 0){
            return String.valueOf(res);
        }
        int len = strs[0].length();
        for (int i = 0; i < len; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if ( i+1 > strs[j].length() ||strs[j].charAt(i) != c) {
                    return String.valueOf(res);
                }
            }
            res.append(c);
        }

        return String.valueOf(res);
    }
}
/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */