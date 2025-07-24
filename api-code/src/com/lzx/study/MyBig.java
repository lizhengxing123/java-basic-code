package com.lzx.study;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Random;

public class MyBig {
    public static void main(String[] args) {
        // 获取一个随机大整数
        Random r = new Random();
        // 取值范围[0, 2 ^ 100 - 1]
        BigInteger bi = new BigInteger(100, r);
        System.out.println(bi); // 996615517261862852523791364037

        // 获取一个指定大整数
        BigInteger bi2 = new BigInteger("100");
        System.out.println(bi2); // 100

        // 获取指定进制的大整数
        BigInteger bi3 = new BigInteger("100", 2);
        System.out.println(bi3); // 4

        // valueof
        // [-16, 16]做了优化，使用的是同一个对象
        BigInteger bi4 = BigInteger.valueOf(16);
        BigInteger bi5 = BigInteger.valueOf(16);
        System.out.println(bi4 == bi5); // true

        BigInteger bi6 = BigInteger.valueOf(17);
        BigInteger bi7 = BigInteger.valueOf(17);
        System.out.println(bi6 == bi7); // false

        // 操作
        // 加
        BigInteger bi8 = bi6.add(bi7);
        System.out.println(bi8); // 34

        // 减
        BigInteger bi9 = bi6.subtract(bi7);
        System.out.println(bi9); // 0

        // 乘
        BigInteger bi10 = bi6.multiply(bi7);
        System.out.println(bi10); // 289

        // 取余
        BigInteger bi11 = bi6.mod(bi7);
        System.out.println(bi11); // 0

        // 除法
        BigInteger bi12 = bi6.divide(bi7);
        System.out.println(bi12); // 1

        // 幂
        BigInteger bi13 = bi6.pow(2);
        System.out.println(bi13); // 289
        System.out.println(bi10.equals(bi13)); // true

        // 比较
        System.out.println(bi6.compareTo(bi7)); // 1

        System.out.println("------------------------------");

        BigDecimal bd = new BigDecimal("0.1");
        System.out.println(bd); // 0.1

        // 有不可预知性，建议使用字符串构造
        BigDecimal bd2 = new BigDecimal(0.9);
        System.out.println(bd2); // 0.90000000000000002220446049250313080847263336181640625

        // valueof
        BigDecimal bd3 = BigDecimal.valueOf(0.9);
        System.out.println(bd3); // 0.9
        // [0, 10] 整数做了优化
        BigDecimal bd4 = BigDecimal.valueOf(10);
        BigDecimal bd5 = BigDecimal.valueOf(10);
        System.out.println(bd4 == bd5); // true

        BigDecimal bd6 = BigDecimal.valueOf(11);
        BigDecimal bd7 = BigDecimal.valueOf(11);
        System.out.println(bd6 == bd7); // false

        // 操作
        // 加
        BigDecimal bd8 = bd6.add(bd7);
        System.out.println(bd8); // 22

        // 减
        BigDecimal bd9 = bd6.subtract(bd7);
        System.out.println(bd9); // 0

        // 乘
        BigDecimal bd10 = bd6.multiply(bd7);
        System.out.println(bd10); // 121

        // 除
        BigDecimal bd11 = bd6.divide(bd7);
        System.out.println(bd11); // 1

        // 除不尽，需要指定保留的位数
        BigDecimal bd12 = bd4.divide(bd7, 2, RoundingMode.HALF_UP);
        System.out.println(bd12); // 0.91


    }
}
