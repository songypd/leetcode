package com.song.netty.fakeSync;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName TImeServerHasnlerExecutePool
 * @Description Valar Morghulis.Valar Dohaeris
 * @Author songyp
 * @Date 2020-09-29 11:39
 */
public class TImeServerHasnlerExecutePool {
    private ExecutorService executorService;

    public TImeServerHasnlerExecutePool(int maxPoolSize, int ququeSize) {
        executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), maxPoolSize, 120L
                , TimeUnit.SECONDS, new ArrayBlockingQueue<>(ququeSize));
    }

    public void execute(Runnable task) {
        executorService.execute(task);
    }
}
