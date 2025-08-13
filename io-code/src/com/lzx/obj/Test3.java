package com.lzx.obj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test3 {
    public static void main(String[] args) {
        // method1();
        method2();


    }

    private static void method1() {
        String regex = "(.{4})([，。])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("赵钱孙李，周吴郑王。");
        while (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
        }
    }

    private static void method2() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");

        // 将集合中的每一个元素进行split分割，然后拼接成新的集合
        ArrayList<String> newList = new ArrayList<String>();
        for (String str : list) {
            String[] split = str.split("");
            Collections.addAll(newList, split);
        }
        // 去重
        newList = new ArrayList<>(new HashSet<>(newList));
        // 排序
        newList.sort(null);

        System.out.println(newList);
    }
}
