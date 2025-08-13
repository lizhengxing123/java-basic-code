package com.lzx.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        // method1();
        // method2();
        // method3();
        method6();
    }

    public static void method1() {
        System.out.println("----------method1----------");
        try {
            FileOutputStream fos = new FileOutputStream("io-code\\a.txt", true);
            byte[] bytes = {97, 98, 99, 100, 101};
            fos.write("\r\n".getBytes());
            fos.write(bytes);
            fos.write(bytes, 1, 3);
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void method2() {
        System.out.println("----------method2----------");
        try {
            FileInputStream fis = new FileInputStream("io-code\\a.txt");
            int b;
            while ((b = fis.read()) != -1) {
                System.out.print((char) b);
            }
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void method3() {
        System.out.println("----------method3----------");
        try {
            FileInputStream fis = new FileInputStream("io-code\\a.txt");
            // 一次读取多个数据
            byte[] bytes = new byte[5];
            // 每次读取到的长度，可能会比5小
            // 当为-1时，说明读取完了
            int len;
            while ((len = fis.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, len));
                System.out.println("====");
                // 如果要要被文件的话，直接使用
                // fos.write(bytes, 0, len);
            }
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 自动关闭的流 JDK 7
    public static void method4() {
        System.out.println("----------method4----------");
        try (
                FileInputStream fis = new FileInputStream("io-code\\a.txt");
                FileOutputStream fos = new FileOutputStream("io-code\\b.txt")
        ) {
            byte[] bytes = new byte[5];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 自动关闭的流 JDK 9
    public static void method5() throws FileNotFoundException {
        System.out.println("----------method5----------");
        FileInputStream fis = new FileInputStream("io-code\\a.txt");
        FileOutputStream fos = new FileOutputStream("io-code\\b.txt");
        try (fis; fos) {
            byte[] bytes = new byte[5];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void method6() {
        System.out.println("----------method6----------");
        // 打印简单表情（U+0000到U+FFFF范围）
        System.out.println("简单表情: \u263A \u2764"); // 微笑符号和爱心

        // 对于超出U+FFFF的表情（如大部分现代emoji），需要使用代理对
        // 例如笑脸😀的Unicode是U+1F600，需要转换为代理对
        System.out.println("笑脸: \uD83D\uDE00");
        System.out.println("竖起大拇指: \uD83D\uDC4D");
        System.out.println("汉堡: \uD83C\uDF54");
        System.out.println("汽车: \uD83D\uDE97");

        String str = "你好ya";
        // 获取字符串的GBK编码
        byte[] bytes = str.getBytes(Charset.forName("GBK"));
        System.out.println(Arrays.toString(bytes));
        // 从GBK编码的字节数组中恢复字符串
        String str2 = new String(bytes, Charset.forName("GBK"));
        System.out.println(str2);
    }
}
