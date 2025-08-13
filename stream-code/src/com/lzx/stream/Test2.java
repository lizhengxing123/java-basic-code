package com.lzx.stream;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test2 {
    public static void main(String[] args) {
        method1();
        method2();
        method3();
    }

    public static void method1() {
        System.out.println("----------method1----------");
        // 将 Stream<Integer> 转换为 IntStream，再求和（以偶数求和为例）
        long sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(i -> i % 2 == 0)  // 过滤偶数（保持原过滤逻辑）
                .mapToInt(Integer::intValue)  // 转换为 IntStream（原始类型流）
                .sum();  // 求和
        System.out.println(sum);  // 输出结果：30（2+4+6+8+10）
    }

    public static void method2() {
        System.out.println("----------method2----------");
        String[] arr = {"a-1", "b-2", "c-3", "d-4", "a-5"};

        Map<String, Integer> map = Arrays.stream(arr)
                .map(s -> s.split("-"))
                .filter(parts -> Integer.parseInt(parts[1]) > 3)
                .collect(
                        Collectors.toMap(
                                parts -> parts[0],
                                parts -> Integer.parseInt(parts[1]),
                                (oldVal, newVal) -> newVal
                        )
                );

        System.out.println(map);
    }

    public static void method3() {
        System.out.println("----------method3----------");
        String[] arr = {"a", "b", "c", "d", "acd"};

        Map<String, Integer> map = Arrays.stream(arr).collect(Collectors.toMap(s -> s, String::length));
        System.out.println(map);

        Arrays.sort(arr, new Test2()::method4);
        System.out.println(Arrays.toString(arr));
    }

    public int method4(String a, String b) {
        int i = b.length() - a.length();
        if (i != 0) {
            return i;
        } else {
            return a.compareTo(b);
        }
    }
}
