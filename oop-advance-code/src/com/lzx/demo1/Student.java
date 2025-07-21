package com.lzx.demo1;

public class Student {
    // 被 static 修饰的成员变量，叫做静态变量
    // 它被该类的所有对象共享，随着类的加载而加载，优先于对象存在，随着类的消失而消失
    // 可以通过【类名.静态变量名】 或者 【对象名.静态变量名】 来访问
    // 它是属于类的，不属于对象的，因此推荐使用【类名.静态变量名】 来访问
    public static String teacherName;

    private String name;
    private int age;
    private char gender;


    public Student() {
    }

    public Student(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    /**
     * 获取
     * @return gender
     */
    public char getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + ", gender = " + gender + "}";
    }

    // 学习
    public void study() {
        System.out.println(this.getName() + "正在学习");
    }
}
