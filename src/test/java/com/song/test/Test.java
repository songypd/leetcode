package com.song.test;

/**
 * @author yuanpeng.song
 * @createTime 2021/2/3
 * @description test
 * Laughter is poison to fear.
 */
public class Test {

    private Boolean isValid(String s){
        String t1 = "()";
        String t2 = "[]";
        String t3 = "{}";
        int len = s.length();
        for (int i = 0;i<len-1;i++){
            s.replace(t1,"").replace(t2,"").replace(t3,"");
        }
        if (s.length() != 0){
            return false;
        }
        return true;
    }

    private Boolean valid(String s){
        int length = s.length() /2;
        for (int i = 0;i <length;i++){
            s=s.replace("()","").replace("[]","").replace("{}","");
        }

        return s.length() == 0;
    }
}
