package com.song.leetcode.answer;

/**
 * @author yuanpeng.song
 * @createTime 2022/2/27
 * @description 最长回文子串
 * Laughter is poison to fear.
 */
public class Q5 {
//    给你一个字符串 s，找到 s 中最长的回文子串。

    /**
     * 最佳的方式是动态规划
     * 最终的答案即为所有 P(i, j) = \text{true}P(i,j)=true 中 j-i+1j−i+1（即子串长度）的最大值
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
//        如果长度小于2，那么本身就是最大的回文字符串
        int length = s.length();
        if (length < 2) {
            return s;
        }
        int begin = 0;
        int maxLen = 1;

        boolean[][] huiwen = new boolean[length][length];
//        单个字符本身就是回文子串
        for (int i = 0; i < length; i++) {
            huiwen[i][i] = true;
        }

        char[] chars = s.toCharArray();
//      递推开始
//        先枚举字符串长度
        for (int l = 2; l <= length; l++) {
            for (int i = 0; i < length; i++) {
                int j = l + i - 1;
                if (j >= length) {
                    break;
                }
                if (chars[i] != chars[j]) {
                    huiwen[i][j] = false;
                } else {
                    if (j - i < 3) {
                        huiwen[i][j] = true;
                    } else {
                        huiwen[i][j] = huiwen[i + 1][j - 1];
                    }
                }
                if (huiwen[i][j] && j - i + 1 > maxLen) {
                    begin = i;
                    maxLen = j - i + 1;
                }

            }
        }
        return s.substring(begin, begin + maxLen);

    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
}
