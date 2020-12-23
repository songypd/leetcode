package com.song.defalutT;

import net.minidev.json.JSONUtil;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureT {

    private static ExecutorService service = Executors.newFixedThreadPool(10);
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> string = CompletableFuture.supplyAsync(() -> {
            System.out.println("这就是个测试" + Thread.currentThread().getName());
            return "end111";
        }, service);

        System.out.println("end");
        System.out.println(string.get());

        CompletableFuture<Integer> integer = CompletableFuture.supplyAsync(() -> {
            System.out.println("这就是个测试" + Thread.currentThread().getName());
            return "111";
        }, service).thenApply(s -> Integer.parseInt(s));

        CompletableFuture.supplyAsync(() -> {
            System.out.println("这就是个测试" + Thread.currentThread().getName());
            return "111";
        }, service).thenRun(()->{
            System.out.println("then run");
        });


        service.shutdown();
    }
}
