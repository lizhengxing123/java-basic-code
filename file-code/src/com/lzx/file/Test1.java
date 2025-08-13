package com.lzx.file;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
        /*method1();
        method2();
        method3();*/
        method4();
        method5();
        // deleteDir(new File("D:\\downloads\\aaa"));
        /*Map<String, Integer> map = new HashMap<>();
        countType(new File("D:\\downloads"), map);
        System.out.println(map);*/
    }

    public static void method1() {
        System.out.println("----------method1----------");
        String parentPath = "D:\\downloads";
        File f1 = new File(parentPath);
        System.out.println(f1); // D:\downloads
        System.out.println(f1.exists());
        System.out.println(f1.isDirectory());

        String childPath = "123.txt";
        File f2 = new File(parentPath, childPath);
        System.out.println(f2); // D:\downloads\123.txt
        System.out.println(f2.exists());
        System.out.println(f2.isFile());

        File f3 = new File(f1, childPath);
        System.out.println(f3); // D:\downloads\123.txt
        System.out.println(f3.exists());
    }

    public static void method2() {
        System.out.println("----------method2----------");
        String parentPath = "D:\\downloads";
        String childPath = "心内一科.png";
        File f1 = new File(parentPath, childPath);
        System.out.println(f1.exists());
        // 文件大小转换为KB，并向上取整
        // 只能获取文件的大小
        System.out.println((int) Math.ceil(f1.length() / 1024.0));
        // 获取文件的最后修改时间，转换为年月日时分秒
        long lastModified = f1.lastModified();
        // 创建格式化器（指定目标格式）
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 时间戳 -> Instant -> LocalDateTime（本地时区）-> 格式化字符串
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(lastModified), ZoneId.systemDefault());
        System.out.println(dateTime.format(formatter)); // 输出格式化后的时间
    }

    public static void method3() {
        System.out.println("----------method3----------");
        String parentPath = "D:\\downloads";
        File f1 = new File(parentPath);

        String childPath1 = "123.txt";
        File f2 = new File(f1, childPath1);
        try {
            boolean b = f2.createNewFile();
            System.out.println(b);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String childPath2 = "bbb";
        File f3 = new File(f1, childPath2);
        boolean b = f3.mkdirs();
        System.out.println(b);

        boolean b1 = f2.delete();
        boolean b2 = f3.delete();
        System.out.println(b1);
        System.out.println(b2);
    }

    public static void method4() {
        System.out.println("----------method4----------");
        String parentPath = "D:\\downloads";
        File f1 = new File(parentPath);

        File[] files = f1.listFiles((file, name) -> file.isFile() && name.endsWith(".png"));
        if (files != null && files.length > 0) {
            System.out.println(files.length);
            for (File file : files) {
                System.out.println(file);
            }
        }
    }

    // 通过递归获取文件夹下的所有文件，并统计总体大小
    public static long getFilesSize(File f) {
        long size = 0;
        if (f.isDirectory()) {
            File[] files = f.listFiles();
            if (files != null) {
                for (File file : files) {
                    size += getFilesSize(file);
                }
            }
        } else {
            size += f.length();
        }
        return size;
    }

    public static void method5() {
        System.out.println("----------method5----------");
        String parentPath = "D:\\downloads";
        File f1 = new File(parentPath);
        long size = getFilesSize(f1);
        // 保留两位小数
        String sizeMB = String.format("%.2f", size / 1024.0 / 1024.0 / 1024.0);
        System.out.println(sizeMB + "GB");
    }

    // 删除多级文件夹
    public static void deleteDir(File f) {
        if (f.isDirectory()) {
            File[] files = f.listFiles();
            if (files != null) {
                for (File file : files) {
                    deleteDir(file);
                }
            }
        }
        f.delete();
    }

    // 计算每一种类型的数量
    public static void countType(File f, Map<String, Integer> map) {
        if (f.isDirectory()) {
            File[] files = f.listFiles();
            if (files != null) {
                for (File file : files) {
                    countType(file, map);
                }
            }
        } else {
            String name = f.getName();
            int index = name.lastIndexOf(".");
            if (index != -1) {
                String type = name.substring(index + 1);
                map.put(type, map.getOrDefault(type, 0) + 1);
            }
        }
    }

}
