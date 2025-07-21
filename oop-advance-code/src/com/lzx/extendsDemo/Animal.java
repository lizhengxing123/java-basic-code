package com.lzx.extendsDemo;

public class Animal {
    public String name;

    public void eat() {
        System.out.println("吃");
    }

    public void drink() {
        System.out.println("喝");
    }

    public Animal() {
        super();
    }

    public Animal(String name) {
        this.name = name;
    }
}
