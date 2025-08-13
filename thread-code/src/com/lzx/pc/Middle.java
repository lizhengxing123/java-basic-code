package com.lzx.pc;

// 中间人
public class Middle {
    // 消费品种类，0表示没有
    public static int productType = 0;

    // 生产数量，最多能生产这些，生产完之后就不会再生产了
    public static int productNum = 0;

    // 锁
    public static final Object lock = new Object();
}
