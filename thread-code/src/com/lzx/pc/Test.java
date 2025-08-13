package com.lzx.pc;

public class Test {
    public static void main(String[] args) {
        // 生产数量
        Middle.productNum = 10;
        // 启动生产者
        Producer producer = new Producer(1);
        producer.setName("厨师1");
        producer.start();
        // 启动消费者
        Consumer consumer = new Consumer(1);
        consumer.setName("吃货1");
        consumer.start();
        // 启动消费者
        Consumer consumer2 = new Consumer(2);
        consumer2.setName("吃货2");
        consumer2.start();
    }
}
