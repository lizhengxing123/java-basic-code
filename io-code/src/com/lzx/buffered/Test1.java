package com.lzx.buffered;

import java.io.*;

public class Test1 {
    public static void main(String[] args) {

    }

    public static void method1() throws IOException {
        System.out.println("----------------method1--------------");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("io-code\\a.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("io-code\\b.txt"));

        int b;
        while((b = bis.read()) != -1){
            bos.write(b);
        }
        bos.close();
        bis.close();
    }

    public static void method2() throws IOException {
        System.out.println("----------------method2--------------");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("io-code\\a.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("io-code\\b.txt"));

        byte[] bytes = new byte[1024];
        int len;
        while((len = bis.read(bytes)) != -1){
            bos.write(bytes, 0, len);
        }
        bos.close();
        bis.close();
    }
}
