package com.lzx.mythread;

public class MyRun implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "==子线程==" + (i + 1));
        }
    }
}
