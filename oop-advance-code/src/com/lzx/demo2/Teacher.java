package com.lzx.demo2;

public class Teacher extends Person implements PartTimeWork, PartTimeWork2 {

    public Teacher() {
    }

    public Teacher(String name, int age) {
        // 调用抽象类里的方法
        super(name, age);
    }

    @Override
    public void work() {
        System.out.println("教书育人");
    }

    @Override
    public void takeExtraClasses() {
        System.out.println("补课" + PartTimeWork.target);
    }

    // 多个实现类中有相同的方法，就必须重写
    // 因为如果不重写，会分不清
    @Override
    public void method1() {
        // 调用静态方法
        PartTimeWork.method2();
        System.out.println("123");
    }


    @Override
    public String takeExtraClasses(String a) {
        return "";
    }

    @Override
    public void takeExtraClasses2() {

    }

    // 重写接口中的默认方法 要去掉default
    /*@Override
    public void method2() {
        PartTimeWork2.super.method2();
    }*/
}
