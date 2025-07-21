package com.lzx.extendsDemo;

public class Dog extends Animal {
    public String name = "狗";

    public void watchHouse() {
        System.out.println("看家");
    }

    // 叫声
    public void shout() {
        System.out.println("犬吠");
    }

    public static void play() {
        System.out.println("dog play");
    }
}
