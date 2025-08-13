package com.lzx.mythread;

import java.util.concurrent.FutureTask;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        threadMethod();
        // runMethod();
        // callMethod();
        // mainMethod();
    }

    private static void threadMethod() {
        MyThread myThread1 = new MyThread("线程1");
        MyThread myThread2 = new MyThread("线程2");
        myThread1.setPriority(10);
        myThread2.setPriority(1);
        myThread1.start();
        myThread2.start();
    }

    private static void runMethod() {
        MyRun myRun = new MyRun();
        Thread thread1 = new Thread(myRun);
        Thread thread2 = new Thread(myRun);
        thread1.setName("线程1");
        thread2.setName("线程2");
        thread1.start();
        thread2.start();
    }

    private static void callMethod() {
        MyCall myCall = new MyCall();
        FutureTask<Integer> futureTask1 = new FutureTask<>(myCall);
        FutureTask<Integer> futureTask2 = new FutureTask<>(myCall);
        Thread thread1 = new Thread(futureTask1);
        Thread thread2 = new Thread(futureTask2);
        thread1.setName("线程1");
        thread2.setName("线程2");
        thread1.start();
        thread2.start();
        try {
            System.out.println("线程1的结果：" + futureTask1.get());
            System.out.println("线程2的结果：" + futureTask2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void mainMethod() throws InterruptedException {
        System.out.println(Thread.currentThread().getPriority());
        System.out.println(Thread.currentThread().getName() + "主线程开始");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + "主线程结束");
    }

}
