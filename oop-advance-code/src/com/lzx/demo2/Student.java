package com.lzx.demo2;

public class Student {
    private String name;
    private int age;

    // 静态代码块
    // 随着类的加载而加载，自动触发，只会执行一次
    // 用于初始化
    static {
        System.out.println("静态代码块");
    }

    // 构造代码块
    // 每次创建对象都会执行
    // 作用：将多个构造方法中的共用代码抽取出来
    // 执行时机：先执行构造代码块，在执行构造方法
    {
        System.out.println("开始创建Student对象");
    }

    public Student() {
        System.out.println("空参构造");
    }

    public Student(String name, int age) {
        System.out.println("有参构造");
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }
}
