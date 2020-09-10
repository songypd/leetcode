package com.song.threads.test;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @ClassName MutiThreadsDemo
 * @Description TODO
 * @Author songyp
 * @Date 2020-01-19 11:52
 * @Version 1.0.0
 */
@Slf4j
public class MutiThreadsDemo {
    private static ExecutorService executor;

    @Before
    public void before(){
        executor = new ThreadPoolExecutor(4, 4, 1000,
                TimeUnit.MICROSECONDS, new LinkedBlockingQueue<Runnable>(), new MutiThreadsDemoThreadFactory());
    }
    @Test
    public void test() {
        Long starTime = System.currentTimeMillis();
        Future<String> test1Result = executor.submit(this::test1);
        Future<String> test2Result = executor.submit(this::test2);
        Future<String> test3Result = executor.submit(this::test3);
        Future<String> test4Result = executor.submit(this::test4);
        List<Future<String>> result = Arrays.asList(test1Result, test2Result, test3Result, test4Result);
        List<String> res = result.stream().map(f -> {
            try {
                return f.get();
            } catch (Exception e) {
                return null;
            }
        }).collect(Collectors.toList());
        log.error("当前总执行耗时为{]", System.currentTimeMillis() - starTime);
        log.info("执行结果为{}", JSON.toJSONString(res));

    }

    public String test1() {
        log.info("test1");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test1";
    }

    public String test2() {
        log.info("test2");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test2";
    }

    public String test3() {
        log.info("test3");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test3";
    }

    public String test4() {
        log.info("test4");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test4";
    }


}

class MutiThreadsDemoThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        return new Thread("ThreadsDemo");
    }
}
