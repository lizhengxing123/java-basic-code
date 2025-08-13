package com.lzx.base;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test2 {
    public static void main(String[] args) {
         method1();
        // method2();
        // method3();
    }

    public static void method1() {
        System.out.println("----------method1----------");
        try {
            FileReader fr = new FileReader("io-code\\a.txt");
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 一次读取多个字符
    public static void method2() {
        System.out.println("----------method2----------");
        try {
            FileReader fr = new FileReader("io-code\\a.txt");
            char[] chs = new char[2];
            int len;
            while ((len = fr.read(chs)) != -1) {
                System.out.print(new String(chs, 0, len));
            }
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 写入数据
    public static void method3() {
        System.out.println("----------method3----------");
        try {
            FileWriter fw = new FileWriter("io-code\\a.txt", true);
            // 写一个换行符
            fw.write("\r\n");
            // 写一个字符
            fw.write(25105);
            // 写一个字符串
            fw.write("hello world");
            // 写一个字符串的一部分
            fw.write("hello world", 0, 5);
            // 写一个字符数组
            char[] chs = {'a', 'b', 'c'};
            fw.write(chs);
            // 写一个字符数组的一部分
            fw.write(chs, 0, 2);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
