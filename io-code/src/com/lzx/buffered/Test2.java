package com.lzx.buffered;

import java.io.*;
import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        String[] arr = {
                "3. 我是3",
                "1. 我是1",
                "5. 我是5",
                "2. 我是2",
                "4. 我是4",
        };
        Object[] arr1 = Arrays.stream(arr).sorted().toArray();
        System.out.println(Arrays.toString(arr1));
    }

    public static void method1() throws IOException {
        System.out.println("-----------method1-----------");
        BufferedReader br = new BufferedReader(new FileReader("io-code\\a.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("io-code\\b.txt"));

        String line;
        while((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
        }

        bw.close();
        br.close();
    }

    public static void method2() throws IOException {
        System.out.println("-----------method2-----------");
        BufferedReader br = new BufferedReader(new FileReader("io-code\\a.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("io-code\\b.txt"));

        char[] chars = new char[1024];
        int len;
        while((len = br.read(chars)) != -1) {
            bw.write(chars, 0, len);
        }

        bw.close();
        br.close();
    }
}
