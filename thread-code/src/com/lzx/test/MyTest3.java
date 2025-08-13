package com.lzx.test;

import java.util.ArrayList;

public class MyTest3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(124);
        list.add(132);
        list.add(112);
        list.add(412);
        list.add(162);
        list.add(172);
        list.add(312);
        list.add(912);
        list.add(102);
        list.add(120);
        MyThread3 thread1 = new MyThread3(list);
        thread1.setName("线程1");
        thread1.start();
        MyThread3 thread2 = new MyThread3(list);
        thread2.setName("线程2");
        thread2.start();
        MyThread3 thread3 = new MyThread3(list);
        thread3.setName("线程3");
        thread3.start();
    }
}
