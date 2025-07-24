package com.lzx.study;

import java.util.Objects;

public class MyObjects {
    public static void main(String[] args) {
        String s = "hello";
        StringBuilder sb = new StringBuilder("hello");
        // 使用的是 String 里面的 equals 方法
        System.out.println(s.equals(sb)); // false
        // 使用的是 Object 里面的 equals 方法
        System.out.println(sb.equals(s)); // false

        // 比较两个对象是否相等
        System.out.println(Objects.equals(s, sb)); // false

        // 判断对象是否为空
        System.out.println(Objects.isNull(s)); // false
        System.out.println(Objects.isNull(null)); // true

        // 判断对象是否不为空
        System.out.println(Objects.nonNull(s)); // true
        System.out.println(Objects.nonNull(null)); // false
    }
}
