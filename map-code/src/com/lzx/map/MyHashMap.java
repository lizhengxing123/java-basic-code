package com.lzx.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MyHashMap {
    public static void main(String[] args) {
        HashMap<Student, String> map = new HashMap<>();

        map.put(new Student("张三", 18), "甘肃");
        map.put(new Student("李四", 20), "新疆");
        map.put(new Student("王五", 22), "青海");
        map.put(new Student("赵六", 24), "西藏");
        map.put(new Student("赵六", 24), "内蒙");

        map.forEach((key, value) -> System.out.println(key + " " + value));

        practice();
    }

    public static void practice() {
        System.out.println("---------practice-------");
        HashMap<String, Integer> map = new HashMap<>();

        Random r = new Random();
        for (int i = 0; i < 80; i++) {
            // A-D 数字
            int j = r.nextInt(4) + 65;
            // 转为字符串
            String s = ((char) j) + "";
            // 增加到map中
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        System.out.println(map);

        int maxCount = 0;
        String maxKey = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        System.out.println("出现次数最多的字符是：" + maxKey + "，出现了：" + maxCount + "次");
    }

}
