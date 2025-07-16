package com.lizhengxing.demo1;

import java.util.ArrayList;

public class Test2 {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        // 新建集合
        ArrayList<Student> students = new ArrayList<>();

        // 添加元素
        students.add(new Student("1", "张三", 23, ""));
        students.add(new Student("2", "李四", 24, ""));
        students.add(new Student("3", "王五", 25, ""));

        System.out.println(students); // 三个地址值

        // 遍历集合
        for (Student student : students) {
            System.out.println("姓名：" + student.getName() + " 年龄：" + student.getAge());
        }
    }
}
