package com.lzx.demo1;

import java.util.StringJoiner;

// 工具类
public class ArrayUtil {
    // 构造器私有化
    private ArrayUtil() {
    }

    // 打印数组
    public static String print(int[] arr) {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (int j : arr) {
            sj.add(j + "");
        }
        return sj.toString();
    }

    // 计算平均值
    public static double average(int[] arr) {
        double sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return sum / arr.length;
    }
}
