package com.lzx.extendsDemo;

public class Cat extends Animal {
    public int type;

    public void catchMouse() {
        System.out.println("抓老鼠");
    }
    public static void mi() {
        System.out.println("咪咪");
    }

    public Cat() {
        super();
    }

    public Cat(String name, int type) {
        super(name);
        this.type = type;
    }

}
