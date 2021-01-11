package com.song.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @ClassName InheritableThreadLocalT
 * @Description Valar Morghulis.Valar Dohaeris
 * @Author songyp
 * @Date 2021-01-09 11:13
 */
public class InheritableThreadLocalT {

    private static ThreadLocal local = new InheritableThreadLocal();

    private static ExecutorService executor = Executors.newFixedThreadPool(2);

    /**
     * execute result ;
     * Connected to the target VM, address: '127.0.0.1:55914', transport: 'socket'
     * main---我是你爸爸
     * pool-1-thread-1---我是你爸爸
     * Disconnected from the target VM, address: '127.0.0.1:55914', transport: 'socket'
     *
     * @param args
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        local.set("我是你爸爸");
        System.out.println(Thread.currentThread().getName() + "---" + local.get());
//        executor.execute(() -> {
//            System.out.println(Thread.currentThread().getName() + "---" + loacl.get());
//        });
        new InheritableThreadLocalT().test();

        executor.shutdown();
    }

    private void test() throws ExecutionException, InterruptedException {


        local.set("天王老子");
        Future future = executor.submit(new Task("任务1"));

        future.get();

        Future future2 = executor.submit(new Task("任务2"));

        future2.get();

        System.out.println("父线程的值："+local.get());
    }

    class Task implements Runnable{

        String str;
        Task(String str){
            this.str = str;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+":"+local.get());
            local.set(str);
            System.out.println(local.get());
        }
    }

}
