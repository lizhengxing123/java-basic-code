package com.lzx.demo3;

public class Test {
    public static void main(String[] args) {
        // 1、创建内部类
        // Car$Engin 子类是用 $ 来连接的
        // Car.Engine ce = new Car().new Engine();
        // System.out.println(ce); // com.lzx.demo3.Car$Engine@4e50df2e

        // 2、获取私有的内部类
        // 需要外部类提供方法
        // Car car = new Car();
        // System.out.println(car.getEngine()); // com.lzx.demo3.Car$Engine@4e50df2e
        // 这个是错误的，因为 Engine 是私有的
        // Car.Engine e1 = car.getEngine();
        // 可以使用多态，使用 Engine 的父类 Object 来接受
        // Object e2 = car.getEngine();
        // System.out.println(e2); // com.lzx.demo3.Car$Engine@1d81eb93

        // 3、使用默认修饰符的内部类
        // 只在本包中可见
        Car car = new Car();
        Car.Engine e3 = car.getEngine();
        System.out.println(e3);
        e3.show();

        // 4、使用 protected 修饰的内部类
        // 在本包和其他包的子类中可见

        // 5、静态内部类初始化
        Car.Inner ci = new Car.Inner();
        ci.show1(); // 调用非静态方法
        Car.Inner.show2(); // 调用非静态方法
    }
}
