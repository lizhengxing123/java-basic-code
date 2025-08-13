package com.lzx.pc;

import java.util.concurrent.BlockingQueue;

public class Consumer1 extends Thread {
    // 阻塞队列
    private BlockingQueue<Integer> queue;

    public Consumer1(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer product = queue.take();
                System.out.println(getName() + "==消费==" + product);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
