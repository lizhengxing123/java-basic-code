package com.lzx.pc;

import java.util.concurrent.BlockingQueue;

public class Producer1 extends Thread {
    // 阻塞队列
    private BlockingQueue<Integer> queue;

    public Producer1(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                queue.put(1);
                System.out.println(getName() + "==生产==" + 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
