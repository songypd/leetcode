package com.song.defalutT;

/**
 * @author yuanpeng.song
 * @createTime 2021/1/19
 * @description switch 的测试
 * Laughter is poison to fear.
 */
public class SwitchT {
    public static void main(String[] args) {
        int i = 9;

        switch (i){
            case 1:
                System.out.println("  ");
            default:
                System.out.println("Error");
            case 2:
                System.out.println("good");
            case 3:
                System.out.println("Best");

        }

        /**
         * output
         *
         * Error
         * good
         * Best
         * */
    }
}
