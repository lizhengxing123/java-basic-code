package com.lzx.test;

public class MyThread1 extends Thread {
    private static int count = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (MyThread1.class) {
                if (count <= 0) {
                    break;
                }
                if (count % 2 == 0) {
                    count--;
                    continue;
                }
                System.out.println(getName() + "==子线程==" + (count--));
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
