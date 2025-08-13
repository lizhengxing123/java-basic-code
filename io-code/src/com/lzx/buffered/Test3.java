package com.lzx.buffered;

import java.io.*;

public class Test3 {
    public static void main(String[] args) {
        int count = getCount();
        System.out.println(count);
        setCount(count++);
        System.out.println("当前为第" + count + "次使用");
    }
    // 从文件中获取使用次数
    public static int getCount() {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("io-code\\count.txt"))) {
            String line = br.readLine();
            count = Integer.parseInt(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
    // 往文件中自动写入次数
    public static void setCount(int count) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("io-code\\count.txt"))) {
            bw.write(count + "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
