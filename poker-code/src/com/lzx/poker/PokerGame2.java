package com.lzx.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class PokerGame2 {
    // 记录数字和牌的对应关系，保证牌的大小
    static HashMap<Integer, String> map = new HashMap<>();

    // 记录所有牌的数字大小，方便打乱排序
    static ArrayList<Integer> list = new ArrayList<>();

    static {
        // 花色
        String[] colors = {"♠", "♣", "♥", "♦"};
        // 数字
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        // 记录牌大小的数字
        int num = 1;

        // 组装牌
        for (String n : numbers) {
            for (String c : colors) {
                map.put(num++, c + n);
            }
        }
        // 大小王
        map.put(num++, "小王");
        map.put(num, "大王");

        // 记录牌的数字
        list.addAll(map.keySet());
    }

    public PokerGame2() {
        // 洗牌
        Collections.shuffle(list);
        // 发牌
        start();
    }

    // 创建玩家发牌
    private void start() {
        // 玩家 使用 TreeSet 会默认排序
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();
        // 底牌
        TreeSet<Integer> lord = new TreeSet<>();

        for (int i = 0; i < list.size(); i++) {
            if (i <= 2) {
                lord.add(list.get(i));
                continue;
            }
            if (i % 3 == 0) {
                player1.add(list.get(i));
            } else if (i % 3 == 1) {
                player2.add(list.get(i));
            } else {
                player3.add(list.get(i));
            }
        }

        // 看牌
        print("玩家1", player1);
        print("玩家2", player2);
        print("玩家3", player3);
        print("底牌", lord);
    }

    // 看牌
    private void print(String name, TreeSet<Integer> list) {
        System.out.print(name + "的牌是：");
        for (Integer i : list) System.out.print(map.get(i) + " ");
        System.out.println();
    }
}
