package com.lzx.demo3;

public class Test1 {
    public static void main(String[] args) {
        // 匿名内部类
        // 1、实现关系
        Swim s = new Swim() {
            @Override
            public void swim() {
                System.out.println("swim");
            }
        };
        s.swim();

        // 2、继承关系
        Animal a = new Animal() {
            @Override
            public void eat() {
                System.out.println("eat");
            }
        };
        a.eat();
    }
}
