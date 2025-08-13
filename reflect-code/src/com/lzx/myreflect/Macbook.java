package com.lzx.myreflect;

public class Macbook implements Computer {
    public static final String brand = "Apple";
    private String name;
    private int price;


    public Macbook() {
    }

    public Macbook(String name, int price) {
        this.name = name;
        this.price = price;
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
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    public String toString() {
        return "Macbook{name = " + name + ", price = " + price + "}";
    }

    @Override
    public void start() {
        System.out.println("macbook启动了");
    }

    @Override
    public void shutdown() {
        System.out.println("macbook关闭了");
    }
}
