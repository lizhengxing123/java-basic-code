package com.lzx.demo2;

public interface PartTimeWork {
    // 常量
    String target = "赚钱";

    void takeExtraClasses();

    // 默认方法，不强制重写
    default void method1() {
        System.out.println("默认方法1");
        method4();
    }

    // 静态方法
    public static void method2() {
        System.out.println("静态方法 method2");
        method3();
    }
    // 为静态方法服务的私有方法
    private static void method3() {
        System.out.println("为静态方法method2服务的私有方法method3");
    }
    // 为默认方法服务的私有方法
    private void method4() {
        System.out.println("为默认方法method1服务的私有方法method4");
    }
}
