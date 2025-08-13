package com.lzx.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyTest5 {
    public static void main(String[] args) {
        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 给线程池提交任务，会自动创建线程执行
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        // 关闭线程池
        executorService.shutdown();
    }
}
