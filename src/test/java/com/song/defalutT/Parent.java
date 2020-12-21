package com.song.defalutT;

public interface Parent {

    default void welcome(){
        System.out.println("Parent say hi");
    }
}
