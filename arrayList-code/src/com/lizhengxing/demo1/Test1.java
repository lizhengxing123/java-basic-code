package com.lizhengxing.demo1;

import java.util.ArrayList;

public class Test1 {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        // 创建集合
        ArrayList<Integer> list = new ArrayList<>();

        // 添加元素
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list); // [1, 2, 3, 4, 5]

        // 删除元素
        // 1、根据索引删除
        list.remove(1);
        System.out.println(list); // [1, 3, 4, 5]
        // 2、根据值删除
        list.remove(Integer.valueOf(3));
        System.out.println(list); // [1, 4, 5]

        // 修改元素 返回被修改的元素
        Integer res = list.set(1, 5);
        System.out.println(res); // 4
        System.out.println(list); // [1, 5, 5]

        // 查询元素
        // 1、根据索引查询
        Integer res1 = list.get(1);
        System.out.println(res1); // 5
        // 2、根据值查询，返回索引，相同的值返回第一个
        int index = list.indexOf(5);
        System.out.println(index); // 1

        // 遍历集合
        // 1、普通for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        // 2、增强for循环
        for (Integer i : list) {
            System.out.println(i);
        }

        // 集合长度
        System.out.println(list.size()); // 3
    }
}
