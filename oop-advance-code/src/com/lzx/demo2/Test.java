package com.lzx.demo2;

public class Test {
    public static void main(String[] args) {
        test2();
    }

    public static void test1() {
        // 局部代码块
        {
            int a = 10;
        }
        // 找不到 a
        // System.out.println(a);

        Student s1 = new Student();
        Student s2 = new Student("张三", 13);
    }

    public static void test2() {
        // 抽象类不能实例化
        // Person p = new Person;

        // 抽象类子类
        Teacher t1 = new Teacher("王五", 50);
        System.out.println(t1.getAge());
        System.out.println(t1.getName());
        t1.work();
        t1.method1();

        test3(t1);
    }

    public static void test3(PartTimeWork p) {
        p.takeExtraClasses();
    }
}
