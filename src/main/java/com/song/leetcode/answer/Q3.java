package com.song.leetcode.answer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuanpeng.song
 * @createTime 2022/2/25
 * @description 无重复字符串的最长子串
 * Laughter is poison to fear.
 */
public class Q3 {
    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int max = 0,left = 0;
        for (int i = 0;i<s.length();i++){
            if (map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcabc");
    }
}
