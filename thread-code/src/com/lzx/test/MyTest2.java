package com.lzx.test;

public class MyTest2 {
    public static void main(String[] args) {
        MyThread2 thread1 = new MyThread2();
        thread1.setName("线程1");
        thread1.start();
        MyThread2 thread2 = new MyThread2();
        thread2.setName("线程2");
        thread2.start();
        MyThread2 thread3 = new MyThread2();
        thread3.setName("线程3");
        thread3.start();
        MyThread2 thread4 = new MyThread2();
        thread4.setName("线程4");
        thread4.start();
        MyThread2 thread5 = new MyThread2();
        thread5.setName("线程5");
        thread5.start();
    }
}
