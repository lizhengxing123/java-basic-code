package com.lzx.test;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.FutureTask;

public class MyTest4 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            list.add(random.nextInt(1000));
        }
        System.out.println(list);

        MyCallable mc = new MyCallable(list);

        FutureTask<Integer> futureTask1 = new FutureTask<>(mc);
        FutureTask<Integer> futureTask2 = new FutureTask<>(mc);

        Thread thread1 = new Thread(futureTask1);
        Thread thread2 = new Thread(futureTask2);

        thread1.setName("线程1");
        thread2.setName("线程2");

        thread1.start();
        thread2.start();

        try {
            System.out.println(thread1.getName() + "==>" + futureTask1.get());
            System.out.println(thread2.getName() + "==>" + futureTask2.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("线程1是否存活：" + thread1.isAlive());
        System.out.println("线程2是否存活：" + thread2.isAlive());
    }
}
