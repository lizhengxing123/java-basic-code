package com.lzx.base;

import java.io.*;
import java.util.Arrays;
import java.util.StringJoiner;

public class Test3 {
    public static void main(String[] args) throws IOException {
        // method1(new File("io-code"), new File("io-code2"));
        // method2(new File("io-code\\a.txt"), "a-enc.txt");
        // method3(new File("io-code\\a-enc.txt"));

        String[] arr = {"12", "7", "87", "9", "13", "32"};
        StringJoiner sj = new StringJoiner("-");
        Arrays.stream(arr).mapToInt(Integer::parseInt).sorted().forEach(i -> sj.add(i + ""));
        System.out.println(sj);
    }

    // 拷贝文件夹
    public static void method1(File src, File dest) throws IOException {
        if (!src.exists()) {
            System.out.println("源文件目录不存在");
            return;
        }
        if (!dest.exists()) {
            boolean b = dest.mkdirs();
            if (!b) {
                System.out.println("目标文件目录不存在，创建失败");
                return;
            }
        }
        File[] files = src.listFiles();
        if (files == null) return;
        for (File file : files) {
            if (file.isFile()) {
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream(new File(dest, file.getName()));
                byte[] bytes = new byte[1024];
                int len;
                while ((len = fis.read(bytes)) != -1) {
                    fos.write(bytes, 0, len);
                }
                fos.close();
                fis.close();
            } else {
                method1(file, new File(dest, file.getName()));
            }
        }
    }

    // 文件加密
    public static void method2(File file, String newName) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(new File(file.getParent(), newName));
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            for (int i = 0; i < len; i++) {
                bytes[i] = (byte) (bytes[i] ^ 0x55);
            }
            fos.write(bytes, 0, len);
        }
        fos.close();
        fis.close();
    }

    // 文件解密
    public static void method3(File file) throws IOException {
        method2(file, file.getName().replace("enc", "dec"));
    }
}
