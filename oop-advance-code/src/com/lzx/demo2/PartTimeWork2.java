package com.lzx.demo2;

public interface PartTimeWork2 {
    String takeExtraClasses(String a);
    void takeExtraClasses2();

    default void method1() {
        System.out.println("2---method2");
    };
}
