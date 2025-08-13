package com.lzx.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "张三", "李四", "王五", "赵六", "王二", "asd", "asssss");

        // System.out.println(callName(list));

        for (int i = 0; i < 3; i++) {
            System.out.println("---------------第" + (i + 1) + "次点名-------------");
            System.out.println(list);
            callName2(list);
        }
    }

    // 随机点名
    public static String callName(List<String> list) {
        Random r = new Random();
        int i = r.nextInt(list.size());
        return list.get(i);
    }

    // 点到之后，不再点到
    public static void callName2(List<String> list) {
        Random r = new Random();
        for (int i = list.size(); i > 0; i--) {
            int j = r.nextInt(i);
            // 点到之后交换到最后
            System.out.print(list.get(j) + " ");
            Collections.swap(list, i - 1, j);
        }
        System.out.println();
    }
}
