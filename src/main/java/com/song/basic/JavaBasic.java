package com.song.basic;

import java.util.Objects;

/**
 * @author yuanpeng.song
 * @createTime 2021/5/16
 * @description java基础
 * Laughter is poison to fear.
 */
public class JavaBasic {
    public static void main(String[] args) {

        String a = null;
//        scanner
//        Scanner scanner = new Scanner(Path.of(""), StandardCharsets.UTF_8);

//        1#2#3
//        字符串不可变更，但是字符串变量可以变化，让他引用到另外一个字符串
//        不可变的字符串有一个优点；编译器可以让字符串共享
//        String join = String.join("#","1","2","3");
//        System.out.println(join);

        Objects.requireNonNull(a,"args not null");
    }


}                
