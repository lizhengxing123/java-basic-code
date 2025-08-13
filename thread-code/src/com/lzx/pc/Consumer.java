package com.lzx.pc;

public class Consumer extends Thread {
    // 要吃的产品类型
    private int productType;

    public Consumer(int productType) {
        this.productType = productType;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (Middle.lock) {
                if (Middle.productNum == 0) {
                    // 没有产品了，就退出
                    break;
                } else {
                    if (Middle.productType != productType) {
                        // 没有当前消费者要吃的，需要等待
                        try {
                            Middle.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        // 有当前消费者要吃的，消费
                        Middle.productNum--;
                        System.out.println(getName() + "==消费==" + Middle.productType);
                        // 将类型重新变为0，表示吃完了
                        Middle.productType = 0;
                        // 唤醒生产，继续生产
                        Middle.lock.notifyAll();
                    }
                }

            }
        }
    }
}
