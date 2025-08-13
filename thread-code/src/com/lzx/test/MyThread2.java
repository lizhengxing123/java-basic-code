package com.lzx.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class MyThread2 extends Thread {
    public static BigDecimal total = new BigDecimal("100.0");
    public static int count = 3;

    private static final double MIN = 0.01;

    @Override
    public void run() {
        synchronized (MyThread2.class) {
            if (count <= 0) {
                System.out.println(getName() + "没有抢到红包");
                return;
            }
            if (count == 1) {
                // 保留两位小数
                System.out.println(getName() + "抢到了" + total + "元");
                total = total.subtract(total);
                count--;
                return;
            }
            double max = total.doubleValue() - (count - 1) * MIN;
            Random r = new Random();
            double money = r.nextDouble(max);
            if (money < MIN) {
                money = MIN;
            }
            money = new BigDecimal(money).setScale(2, RoundingMode.HALF_UP).doubleValue();
            System.out.println(getName() + "抢到了" + money + "元");
            total = total.subtract(BigDecimal.valueOf(money));
            count--;
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
