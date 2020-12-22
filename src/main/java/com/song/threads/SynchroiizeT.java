package com.song.threads;

public class SynchroiizeT {

    private static Object o = new Object();

    public static void main(String[] args) {
        synchronized (o){
            System.out.println(" hello");
        }
    }

    public synchronized void t1(){
        System.out.println("ti");
    }

    public static  synchronized void t2(){
        System.out.println("t2");
    }
}
