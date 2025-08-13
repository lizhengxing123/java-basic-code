package com.lzx.test;

public class MyTest1 {
    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1();
        thread1.setName("线程1");
        thread1.start();

        MyThread1 thread2 = new MyThread1();
        thread2.setName("线程2");
        thread2.start();
    }
}
