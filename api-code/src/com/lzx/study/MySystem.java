package com.lzx.study;

public class MySystem {
    public static void main(String[] args) {
        // 1、退出虚拟机
        // 0表示正常退出
        // System.exit(0);
        // 非0表示异常退出
        // System.exit(1);

        // 2、打印信息
        System.out.println("hello world");

        // 3、获取当前时间
        System.out.println(System.currentTimeMillis()); // 1753153317602

        // 4、拷贝数组
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = new int[arr1.length];
        System.arraycopy(arr1, 0, arr2, 2, 2);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }

        // 5、获取系统属性
        System.out.println(System.getProperty("os.name")); // Windows 11
        System.out.println(System.getProperty("user.name")); // lzx
        System.out.println(System.getProperty("user.dir")); // D:\study\java\basic-code\api-code
    }
}
