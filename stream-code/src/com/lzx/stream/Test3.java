package com.lzx.stream;

import java.util.Arrays;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        method1();
        method2();
        method3();
        method4();
        method5();
    }

    public static void method1() {
        System.out.println("----------method1----------");
        List<String> list = List.of("1", "2", "3");

        list.stream().map(Integer::parseInt).forEach(System.out::println);
    }

    public static void method2() {
        System.out.println("----------method2----------");
        List<Integer> list = List.of(1, 2, 3, 4);
        Integer[] arr = list.toArray(new Integer[0]);
        System.out.println(Arrays.toString(arr));
    }

    public static void method3() {
        System.out.println("----------method3----------");
        List<String> list = List.of("张三-23", "李四-24", "王五-25");
        Student[] array1 = list.stream()
                .map(Student::new)
                .toArray(Student[]::new);
        System.out.println(Arrays.toString(array1));
    }

    public static void method4() {
        System.out.println("----------method4----------");
        List<String> list = List.of("zhangsan-23", "lisi-24", "wangwu-25");
        String[] array2 = list.stream()
                .map(Student::new)
                .map(Student::getName)
                .toArray(String[]::new);
        System.out.println(Arrays.toString(array2));
    }

    public static void method5() {
        System.out.println("----------method5----------");
        List<Student> list = List.of(new Student("zhangsan", 23), new Student("lisi", 24), new Student("wangwu", 25));
        String[] array3 = list.stream()
                // 有两种写法
                // .map(Student::info)
                .map(new Student()::info)
                .toArray(String[]::new);
        System.out.println(Arrays.toString(array3));
    }
}
