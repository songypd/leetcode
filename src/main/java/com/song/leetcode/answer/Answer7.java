package com.song.leetcode.answer;

/**
 * @ClassName Answer7
 * @Description Valar Morghulis.Valar Dohaeris
 * @Author songyp
 * @Date 2020-12-16 19:18
 */
public class Answer7 {


    public static void main(String[] args) {
        int res = new Answer7().reverse(-32);
        System.out.println("end");
    }

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int head = x % 10;
            if (res>Integer.MAX_VALUE /10 ||(res ==Integer.MAX_VALUE /10 && head >7)){
                return 0;
            }
            if (res<Integer.MIN_VALUE /10 ||(res ==Integer.MIN_VALUE /10 && head >8)){
                return 0;
            }
            x /=10;
            res = res * 10 + head;
        }
        return res;
    }

    public int reverseEasy(int x) {
        Boolean gtZero = x >= 0;
        int len = String.valueOf(x).length();
        String xStr = gtZero ? String.valueOf(x) : String.valueOf(x).substring(1, len);
        String[] res = xStr.split("");
        StringBuilder sb = new StringBuilder();
        for (int i = gtZero ? len - 1 : len - 2; i >= 0; i--) {
            sb.append(res[i]);
        }
        long r = Long.valueOf(sb.toString());
        if (r > Integer.MAX_VALUE) {
            return 0;
        }

        return gtZero ? (int) r : (int) (0 - r);
    }
}

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */