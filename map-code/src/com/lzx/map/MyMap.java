package com.lzx.map;

import java.util.HashMap;
import java.util.Map;

public class MyMap {
    public static void main(String[] args) {
        // base();
        loop();
        loop2();
        loop3();
        loop4();
    }

    public static void base() {
        System.out.println("---------base-------");
        // 创建map对象
        Map<String, Integer> map = new HashMap<>();

        // 增加
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        System.out.println(map.put("d", 4)); // null

        System.out.println(map);

        // 移除
        map.remove("a");
        map.remove("c", 3);
        System.out.println(map);

        // 修改 返回值是被覆盖的值
        System.out.println(map.put("b", 5)); // 2
        System.out.println(map);

        // 获取
        System.out.println(map.get("d"));

        map.keySet().forEach(System.out::println);
        map.values().forEach(System.out::println);

        // 包含
        System.out.println(map.containsKey("a"));
        System.out.println(map.containsValue(5));

        // 长度
        System.out.println(map.size());

        System.out.println(map.isEmpty());


        /*map.clear();
        System.out.println(map.isEmpty());*/
    }

    // 遍历
    public static void loop() {
        System.out.println("---------loop-------");
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    public static void loop2() {
        System.out.println("---------loop2-------");
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        map.keySet().forEach(k -> System.out.println(k + ":" + map.get(k)));
    }

    public static void loop3() {
        System.out.println("---------loop3-------");
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        map.values().forEach(System.out::println);
    }

    public static void loop4() {
        System.out.println("---------loop4-------");
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        map.entrySet().forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));
    }

}
