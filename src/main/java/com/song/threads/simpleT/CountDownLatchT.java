package com.song.threads.simpleT;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName CountDownLatchT
 * @Description Valar Morghulis.Valar Dohaeris
 * @Author songyp
 * @Date 2020-12-14 16:42
 */
public class CountDownLatchT {


    private static ExecutorService executors = Executors.newFixedThreadPool(5);
    private static ExecutorService service = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws InterruptedException {


        final CountDownLatch count = new CountDownLatch(5);
        final CountDownLatch latch = new CountDownLatch(5);
        final CountDownLatch open = new CountDownLatch(1);

        int i = 0;

        while (i < 5) {
            executors.submit(() -> {
                try {
                    open.await();
                    System.out.println(Thread.currentThread().getName() + "号贵宾上门");
                    count.countDown();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            service.submit(() -> {
                try {
                    open.await();
                    System.out.println(Thread.currentThread().getName() + "号贵宾的技师准备好了");
                    latch.countDown();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            i++;


        }
        System.out.println("开门了");
        open.countDown();
        latch.await();
        System.out.println("技师开始服务");
        count.await();
        System.out.println("贵宾到齐了，开始上菜");

        System.out.println("all end");
        executors.shutdown();
        service.shutdown();
    }


}
