package com.song.threads.simpleT;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName CyclicBarrierT
 * @Description Valar Morghulis.Valar Dohaeris
 * @Author songyp
 * @Date 2020-12-14 17:36
 */
public class CyclicBarrierT {

private static ExecutorService executorService = Executors.newFixedThreadPool(5);
private static ExecutorService service = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);


        for (int i = 0;i<5;i++){
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName()+"学员准备好了");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"学生到le");

            });
        }


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0;i<5;i++){
            service.submit(() -> {
                System.out.println(Thread.currentThread().getName()+"老师准备好了");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"老师到了");

            });
        }

        System.out.println("开始开会");

        service.shutdown();
        executorService.shutdown();
    }
}
