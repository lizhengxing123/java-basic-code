package com.lzx.demo3;

public class Car {
    String brand = "bmw";
    static int age;
    private String color;

    public void show() {
        // System.out.println("num: " + num);
    }

    // 成员内部类
    class Engine {
        String brand = "v8";
        int age;
        // jdk16 以后可以使用静态变量
        static int num;

        public void show() {
            String brand = "w12";

            // 获取局部变量
            System.out.println("Brand: " + brand); // Brand: w12
            // 获取本类的成员变量
            System.out.println("Engine Brand: " + this.brand); // Engine Brand: v8
            // 获取外部类成员变量
            System.out.println("Car Brand: " + Car.this.brand); // Car Brand: bmw
        }
    }

    public Engine getEngine() {
        return new Engine();
    }

    // 静态内部类
    static class Inner {
        public void show1() {
            System.out.println("Inner show");
            // 访问静态变量
            System.out.println(Car.age);
            // 访问非静态变量，需要先创建实例对象
            Car car = new Car();
            System.out.println(car.color);
        }

        public static void show2() {
            System.out.println("Inner static show2");
            // 访问静态变量
            System.out.println(Car.age);
            // 访问非静态变量，需要先创建实例对象
            Car car = new Car();
            System.out.println(car.color);
        }
    }
}
