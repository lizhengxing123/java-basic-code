package com.lzx.pc;

import java.util.Random;

public class Producer extends Thread {
    // 要生产的产品类型
    private int productType;

    public Producer(int productType) {
        this.productType = productType;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            synchronized (Middle.lock) {
                if (Middle.productNum == 0) {
                    // 生产数量达到极限，退出循环
                    break;
                } else {
                    if (Middle.productType != 0) {
                        // 有产品了，等待消费者去消费
                        try {
                            Middle.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        // 没有产品了，生产
                        Middle.productType = random.nextInt(2) + 1;
                        System.out.println(getName() + "==生产==" + Middle.productType);
                        // 唤醒消费者，继续消费
                        Middle.lock.notifyAll();
                    }
                }
            }
        }
    }
}
