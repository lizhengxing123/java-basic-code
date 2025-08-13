package com.lzx.map;

import java.util.TreeMap;

public class MyTreeMap {
    public static void main(String[] args) {
        TreeMap<Student, Integer> map = new TreeMap<>();
        map.put(new Student("zhangsan", 24), 100);
        map.put(new Student("lisi", 20), 200);
        map.put(new Student("wangwu", 22), 300);
        map.put(new Student("zhaoliu", 24), 400);

        map.forEach((key, value) -> System.out.println(key + " " + value));

        countChar("prbbiAszhelloadvcdvVworldcdeggfyt");

        print(1, 2, 3, 4, 5);
        print2("a", 1, "b", "c", "d");
    }

    // 统计字符串中每个字符出现的次数
    public static void countChar(String str) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        map.forEach((key, value) -> System.out.print(key + "（" + value + "） "));
    }

    // 可变参数
    public static void print(int... args) {
        for (int i : args) {
            System.out.println(i);
        }
    }

    // 可变参数
    public static void print2(String a, int b, String... args) {
        System.out.println(a);
        System.out.println(b);
        for (String s : args) {
            System.out.println(s);
        }
    }
}
