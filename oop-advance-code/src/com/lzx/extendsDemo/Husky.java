package com.lzx.extendsDemo;

public class Husky extends Dog{
    public String name = "哈士奇";

    public void breakHome() {
        System.out.println("拆家");
    }

    @Override
    public void shout() {
        System.out.println("汪汪汪");
    }

    public static void play() {
        System.out.println("husky play");
    }
}
