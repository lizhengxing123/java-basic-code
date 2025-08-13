package com.lzx.mythread;

public class Test2 {
    public static void main(String[] args) {
        MyThread2 myThread21 = new MyThread2("窗口1");
        MyThread2 myThread22 = new MyThread2("窗口2");
        MyThread2 myThread23 = new MyThread2("窗口3");
        myThread21.start();
        myThread22.start();
        myThread23.start();
    }
}
