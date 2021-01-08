package com.song.leetcode.answer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName Answer67
 * @Description Valar Morghulis.Valar Dohaeris
 * @Author songyp
 * @Date 2021-01-08 14:37
 * https://leetcode-cn.com/problems/add-binary/
 */
public class Answer67 {
    public String addBinaryV1(String a, String b) {

        return Integer.toBinaryString(Integer.parseInt(a,2)+Integer.parseInt(b,2));
    }

    public static String addBinaryV2(String a, String b) {
        int alen = a.length();
        int blen = b.length();
        StringBuilder sb = new StringBuilder();
        if (alen != blen){
            if (alen<blen){
                a = getSameLengthString(a, blen, alen, sb);
            }else {
                b = getSameLengthString(b, alen, blen, sb);
            }
        }
        String[] as = a.split("");
        String[] bs = b.split("");

        int length = as.length;

        boolean jw = false;
        List<String> list= new ArrayList<>();
        for (int i = length-1;i>=0;i--){
            int r = Integer.parseInt(as[i])+Integer.parseInt(bs[i])+(jw?1:0);

            if (r>=2){
                jw = true;
                list.add(String.valueOf(r%2));
            }else {
                list.add(String.valueOf(r));
                jw=false;
            }
            if (i ==0&&jw){
               list.add("1");
            }
        }

        String collect = list.stream().collect(Collectors.joining(""));


        System.out.println("end");
        return new StringBuilder(collect).reverse().toString();
    }


    protected static String getSameLengthString(String b, int alen, int blen, StringBuilder sb) {
        for (int i = alen - blen - 1; i >= 0; i--) {
            sb.append("0");
        }
        sb.append(b);
        b = sb.toString();
        return b;
    }

    public static void main(String[] args) {
        addBinaryV2("1111","1111");
    }
}
/**
 *
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解题思路；
 *
 * 两个数组相加，和大于2的向前进1，自身为0
 *
 * */