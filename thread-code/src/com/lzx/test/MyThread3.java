package com.lzx.test;

import java.util.ArrayList;
import java.util.Collections;

public class MyThread3 extends Thread {
    // 抽奖集合
    private ArrayList<Integer> list;

    // 抽中的奖项集合
    private ArrayList<Integer> winList = new ArrayList<>();

    public MyThread3(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (MyThread3.class) {
                if (list.isEmpty()) {
                    if (!winList.isEmpty()) {
                        System.out.println(getName() + "==抽奖结束==");
                        System.out.println(getName() + "==抽中的奖项==" + winList);
                        System.out.println(getName() + "==抽中的奖项总数==" + winList.size());
                        System.out.println(getName() + "==抽中的奖项金额==" + winList.stream().mapToInt(Integer::intValue).sum());
                        System.out.println(getName() + "==抽中的奖项金额平均值==" + winList.stream().mapToInt(Integer::intValue).average().getAsDouble());
                    }
                    break;
                }
                Collections.shuffle(list);
                int money = list.removeFirst();
                winList.add(money);
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
