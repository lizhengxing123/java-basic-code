package com.lzx.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {
    public static void main(String[] args) {
        method1();
        method2();
        method3();
        method4();
        method5();
        method6();
        method7();
        method8();
    }

    public static void method1() {
        System.out.println("-----------method1-----------");
        List<String> list = List.of("a", "b", "c", "ace", "king");
        list.stream().filter(s -> s.length() >= 3).forEach(System.out::println);
    }

    public static void method2() {
        System.out.println("----------method2----------");
        Map<String, Integer> map = Map.of("a", 1, "b", 2, "c", 3);
        map.keySet().stream().filter(s -> map.get(s) >= 3).forEach(System.out::println);
    }

    public static void method3() {
        System.out.println("----------method3----------");
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.stream(arr).filter(i -> i % 2 == 0).forEach(System.out::println);
    }

    public static void method4() {
        System.out.println("----------method4----------");
        // int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // 基本数据类型不会自动装箱
        // Stream.of(arr).forEach(System.out::println);
        Stream.of(1, 2, 3, 4, 5).filter(i -> i % 2 == 1).forEach(System.out::println);
    }

    public static void method5() {
        System.out.println("----------method5----------");
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // skip 跳过前两个元素
        // limit 限制元素数量
        System.out.println(Arrays.stream(arr).skip(2).limit(3).sum());
    }



    public static void method6() {
        System.out.println("----------method6----------");
        String[] arr1 = {"1", "2", "3", "4", "5"};
        String[] arr2 = {"1", "2", "9", "10"};

        // concat 合并两个流
        // distinct 去重
        System.out.println(Stream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).distinct().count());
    }



    public static void method7() {
        System.out.println("----------method7----------");
        String[] arr1 = {"a-1", "b-2", "c-3", "d-4", "e-5"};

        // 将 map 改为 mapToInt，直接生成 IntStream，再调用 toArray() 得到 int[]
        int[] arr = Stream.of(arr1)
            .mapToInt(s -> Integer.parseInt(s.split("-")[s.split("-").length - 1])) // 转换为 IntStream
            .toArray(); // IntStream.toArray() 直接返回 int[]
        System.out.println(Arrays.toString(arr));
    }

    public static void method8() {
        System.out.println("----------method8----------");
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "a-1", "b-2", "c-3", "d-4", "e-5", "a-9");
        List<String> list1 = list.stream().map(s -> s.split("-")[0]).toList();
        System.out.println(list1);
        Set<String> set = list.stream().map(s -> s.split("-")[0]).collect(Collectors.toSet());
        System.out.println(set);
        Map<String, Integer> map = list.stream()
            .map(s -> s.split("-")) // 将字符串拆分为 ["键", "值"] 数组
            .collect(Collectors.toMap(
                parts -> parts[0], // 键：数组第1个元素（如 "a"）
                parts -> Integer.parseInt(parts[1]), // 值：数组第2个元素转整数（如 1）
                (oldVal, newVal) -> newVal // 重复键时保留新值（如 "a-9" 覆盖 "a-1"）
            ));
        System.out.println(map);
    }

}
