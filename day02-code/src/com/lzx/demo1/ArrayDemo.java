package com.lzx.demo1;

import java.util.Random;

public class ArrayDemo {
    public static void main(String[] args) {
        // 1、定义数组
        int[] arr = {1, 2, 3, 4, 5};

        // 数组的地址值：在内存中的位置
        System.out.println(arr); // [I@b4c966a
        // 地址值的含义
        // [:表示数组
        // I:表示数组中存储的数据类型为int
        // @:表示分隔符，固定格式
        // b4c966a:表示十六进制的地址值

        // 2、访问数组中的元素
        System.out.println(arr[3]); // 4

        // 3、修改数组中的元素
        arr[3] = 14;
        System.out.println(arr[3]); // 14

        // 4、遍历数组
        // 4.1、普通for循环
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        // 4.2、增强for循环，无法访问索引，只能拿到值
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        System.out.println(sum);

        // 5、数组的动态初始化
        int[] arr1 = new int[5];
        System.out.println(arr1[0]); // 默认初始化值：0
        // 默认初始化值：
        // 整数类型：0
        // 浮点类型：0.0
        // 字符类型：'\u0000' 空格
        // 布尔类型：false
        // 引用类型：null

        // 6、数组方法
        // 6.1、求最值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = arr[i] > max ? arr[i] : max;
        }
        System.out.println(max); // 14

        // 6.2、反转数组
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        // 6.3、打乱数组顺序
        Random r = new Random();
        for (int i = 0; i < arr.length - 1; i++) {
            int j = r.nextInt(arr.length - i - 1) + i + 1;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println("------------");

        // 7、二维数组
        int[][] a = {
                {1, 22, 3},
                {34, 5, 46, 7, 88, 9}
        };

        System.out.println(a[1][4]);
        printArray(a);

        System.out.println("=====================");

        int[][] b = new int[3][4];
        b[1][2] = 10;
        printArray(b);

    }

    // 打印二维数组
    public static void printArray(int[][] arr) {
        for (int[] i : arr) {
            for (int k : i) {
                System.out.print(k + "\t");
            }
            System.out.println();
        }
    }
}
