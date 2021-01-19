package com.song.threads.lockT;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ReentranLockT
 * @Description Valar Morghulis.Valar Dohaeris
 * @Author songyp
 * @Date 2021-01-05 15:37
 */
public class ReentranLockT {



    //此处可以考察公平锁与非公平锁的区别
//    公平锁
    /**
     * Creates an instance of {@code ReentrantLock} with the
     * given fairness policy.
     *
     * public ReentrantLock(boolean fair) {
     *       sync = fair ? new FairSync() : new NonfairSync();
     *     }
     *
     *
     *公平锁-----》new ReentrantLock(true)
     * 线程a获得到了锁
     * 线程b获得到了锁
     * 线程c获得到了锁
     * 线程d获得到了锁
     * 线程e获得到了锁
     * 线程a获得到了锁
     * 线程b获得到了锁
     * 线程c获得到了锁
     * 线程d获得到了锁
     * 线程e获得到了锁
     * 线程a获得到了锁
     * 线程b获得到了锁
     * 线程c获得到了锁
     * 线程d获得到了锁
     * 线程e获得到了锁
     *
     * 非公平所-----》new ReentrantLock(false);
     *
     * @param fair {@code true} if this lock should use a fair ordering policy
     */
//    private static final Lock lock = new ReentrantLock(true);
    private static final Lock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        new Thread(()->test(),"线程a").start();
        new Thread(()->test(),"线程b").start();
        new Thread(()->test(),"线程c").start();
        new Thread(()->test(),"线程d").start();
        new Thread(()->test(),"线程e").start();
    }

    public static void test(){

        for (int i= 0;i < 3;i++){
            try{
                lock.lock();
                System.out.print(Thread.currentThread().getName()+"获得到了锁\n");
//                Thread.sleep(100);
                TimeUnit.SECONDS.sleep(1);
            }catch(Exception ex){
                ex.printStackTrace();
            }finally {
                lock.unlock();
            }

        }
    }
}
