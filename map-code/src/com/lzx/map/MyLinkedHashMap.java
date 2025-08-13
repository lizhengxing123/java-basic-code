package com.lzx.map;

import java.util.LinkedHashMap;

public class MyLinkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<Student, Integer> map = new LinkedHashMap<>();
        map.put(new Student("zhangsan", 18), 1);
        map.put(new Student("lisi", 20), 2);
        map.put(new Student("wangwu", 22), 3);
        map.put(new Student("zhaoliu", 24), 4);

        System.out.println(map);
    }
}
