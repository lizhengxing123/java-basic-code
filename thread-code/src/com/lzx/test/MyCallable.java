package com.lzx.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private List<Integer> list;

    public MyCallable(List<Integer> list) {
        this.list = list;
    }

    @Override
    public Integer call() throws Exception {
        List<Integer> winList = new ArrayList<Integer>();
        while (true) {
            synchronized (MyCallable.class) {
                if (list.isEmpty()) {
                    break;
                }
                Collections.shuffle(list);
                int money = list.removeFirst();
                winList.add(money);
            }
            Thread.sleep(10);
        }
        System.out.println(Thread.currentThread().getName() + "==>" + winList);
        return Collections.max(winList);
    }
}
