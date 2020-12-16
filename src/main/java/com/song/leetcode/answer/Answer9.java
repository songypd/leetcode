package com.song.leetcode.answer;

/**
 * @ClassName Answer9
 * @Description Valar Morghulis.Valar Dohaeris
 * @Author songyp
 * @Date 2020-12-16 23:56
 */
public class Answer9 {

    public static void main(String[] args) {
        boolean res = new Answer9().isPalindrome(1000000001);
        System.out.println("end");
    }

    //0算相等的情况
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int tmp = x;
        int res = 0;
        while (tmp != 0) {
            int head = tmp % 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && head > 7)) {
                return false;
            }
            res = res * 10 + head;
            tmp /= 10;
        }

        return res == x;
    }
}
