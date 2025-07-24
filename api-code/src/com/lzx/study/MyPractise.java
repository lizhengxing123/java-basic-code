package com.lzx.study;

import java.util.ArrayList;
import java.util.Scanner;

public class MyPractise {
    public static void main(String[] args) {
        method1();
    }

    private static void method2() {
        ArrayList<Integer> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);


        while (sum(list) <= 200) {
            System.out.println("请输入一个整数");

            String str = sc.nextLine();

            if(str.matches("[1-9]\\d?|100")) {
                list.add(Integer.parseInt(str));
            } else {
                System.out.println("输入的整数有误");
            }
        }

        // 打印集合
        System.out.println(list);
    }

    // 计算集合中的和
    public static int sum(ArrayList<Integer> list) {
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        return sum;
    }

    // 计算集合中的平均值
    public static void method1() {
        int num = 123;
        StringBuilder sb = new StringBuilder();
        // 除基取余法
        while (num != 0) {
            sb.insert(0, num % 2);
            num /= 2;
        }
        System.out.println(sb.toString() + "---" + Integer.toBinaryString(123));
    }
}
