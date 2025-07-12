package com.lzx.demo1;

public class MethodDemo {
    public static void main(String[] args) {
        System.out.println(mySum(23, 45));
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(arr[1]);
        change(arr);
        System.out.println(arr[1]);
    }

    public static int mySum(int a, int b) {
        return a + b;
    }

    public static void change(int[] arr) {
        arr[1] = 100;
    }
}
