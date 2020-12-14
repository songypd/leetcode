package com.song.leetcode.answer;

/**
 * @ClassName Divide
 * @Description Valar Morghulis.Valar Dohaeris
 * @Author songyp
 * @Date 2020-12-14 11:33
 */
public class Divide {

    public static void main(String[] args) {
//        int a = -8;
//        int b = a >> 3;
//
//        int d =   c << 3;

        int c = 3;
        int i = 100;

        int d = c << 3;

        int r =new Divide().divide(5,100);
        System.out.println("end");
    }



    public int divide(int dividend, int divisor) {
        int n = 1;
        int last = divisor -dividend;
        while(last >=dividend){
            last = last -dividend;
            n++;
            if (last<dividend){
                break;
            }
        }

        return n;
    }
}
