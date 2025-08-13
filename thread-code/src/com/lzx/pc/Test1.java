package com.lzx.pc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test1 {
    public static void main(String[] args) {
        // 阻塞队列
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);

        // 启动生产者
        Producer1 producer = new Producer1(queue);
        producer.setName("厨师1");
        producer.start();

        // 启动消费者
        Consumer1 consumer = new Consumer1(queue);
        consumer.setName("吃货1");
        consumer.start();
    }
}
