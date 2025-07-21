package com.lzx.extendsDemo;

import com.lzx.demo1.Student;

public class Test1 {
    public static void main(String[] args) {
        final int PI = 3;
        System.out.println(PI);

        final Student s1 = new Student("张三", 23, '男');
        System.out.println(s1);
        s1.setAge(12);
        System.out.println(s1);

    }
}
