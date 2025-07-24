package com.lzx.study;

import java.io.IOException;
import java.io.InputStream;

public class MyRuntime {
    public static void main(String[] args) throws IOException {
        // 获取 runtime 对象
        Runtime r = Runtime.getRuntime();

        // 1、退出虚拟机
        // r.exit(0);

        // 2、获取cpu线程数
        System.out.println(r.availableProcessors()); // 18

        // 3、获取虚拟机最大内存
        System.out.println(r.maxMemory() / 1024 / 1024); // 8072

        // 4、获取虚拟机空闲内存
        System.out.println(r.freeMemory() / 1024 / 1024); // 502

        // 5、已经获取的内存
        System.out.println(r.totalMemory() / 1024 / 1024); // 508

        // 6、运行命令
        Process p = r.exec("node --version");

        // 7、获取命令运行结果
        InputStream is = p.getInputStream();
        byte[] bytes = is.readAllBytes();
        System.out.println(new String(bytes)); // v18.20.4
    }
}
