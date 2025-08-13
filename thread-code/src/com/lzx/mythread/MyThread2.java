package com.lzx.mythread;

public class MyThread2 extends Thread {
    private static int ticket;

    private static final Object lock = new Object();

    public MyThread2() {
    }

    public MyThread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (ticket < 100) {
            synchronized (lock) {
                if (ticket < 100) {
                    System.out.println(getName() + "卖出了第" + (++ticket) + "票");
                    try {
                        sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}
