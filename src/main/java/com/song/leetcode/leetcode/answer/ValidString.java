package com.song.leetcode.leetcode.answer;

/**
 * @ClassName ValidString
 * @Description Valar Morghulis.Valar Dohaeris
 * @Author songyp
 * @Date 2020-12-11 00:07
 */
public class ValidString {

    public static void main(String[] args) {

        String s = "[{({(){}})}]";


        boolean f = new ValidString().isValid(s);

        System.out.println("eof");
    }

    public boolean isValid(String s) {
        int length = s.length() /2;
        for (int i = 0;i <length;i++){
            s=s.replace("()","").replace("[]","").replace("{}","");
        }

        return s.length() == 0;
    }
}


/**
 * <P>题目</P>
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */