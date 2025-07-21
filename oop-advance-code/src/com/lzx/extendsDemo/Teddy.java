package com.lzx.extendsDemo;

public class Teddy extends Dog{
    public String name = "泰迪";

    public void touch() {
        System.out.println("蹭一蹭");
    }

    @Override
    public void shout() {
        System.out.println("嘤嘤嘤");
    }
}
