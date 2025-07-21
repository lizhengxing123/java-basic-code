package com.lzx.demo1;

public class StudentTest {
    public static void main(String[] args) {
        Student s1 = new Student("张三", 20, '男');

        System.out.println(s1);
        s1.study();
    }
}
