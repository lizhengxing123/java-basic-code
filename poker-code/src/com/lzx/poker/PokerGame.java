package com.lzx.poker;

import java.util.*;

public class PokerGame {
    // 记录每张牌的价值来进行排序
    static HashMap<String, Integer> map = new HashMap<>();
    // 牌盒，装所有的牌
    static ArrayList<String> list = new ArrayList<>();

    static {
        // 花色
        String[] colors = {"♠", "♣", "♥", "♦"};
        // 数字
        String[] numbers = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        // 组装牌
        for (String color : colors) {
            for (String number : numbers) {
                list.add(color + number);
            }
        }
        // 大小王
        list.add("小王");
        list.add("大王");

        // 设置牌的价值 没设置就是牌本身
        map.put("J", 11);
        map.put("Q", 12);
        map.put("K", 13);
        map.put("A", 14);
        map.put("2", 15);
        map.put("小王", 16);
        map.put("大王", 16);
    }

    public PokerGame() {
        // 洗牌
        Collections.shuffle(list);
        // 发牌
        start();
    }

    // 创建玩家发牌
    private void start() {
        // 玩家
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        // 底牌
        ArrayList<String> lord = new ArrayList<>();

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
    private void print(String name, ArrayList<String> list) {
        // 先排序
        sort(list);
        System.out.print(name + "的牌是：");
        for (String s : list) System.out.print(s + " ");
        System.out.println();
    }

    // 将牌进行排序
    private void sort(ArrayList<String> list) {
        Collections.sort(list, (o1, o2) -> {
            // 牌的花色
            String color1 = o1.substring(0, 1);
            String color2 = o2.substring(0, 1);
            // 牌的数字
            int number1 = getValue(o1);
            int number2 = getValue(o2);
            // 比较牌的价值
            int i = number1 - number2;
            if (i != 0) {
                return i;
            }
            // 价值相同，比较花色
            return color1.compareTo(color2);
        });
    }

    // 根据牌获取价值
    private int getValue(String card) {
        if (card.endsWith("王")) {
            return map.get(card);
        }
        String number = card.substring(1);
        if (map.containsKey(number)) {
            return map.get(number);
        }
        return Integer.parseInt(number);
    }

    // 将map转变为不可变集合
    private static Map<String, Integer> toImmutableMap(Map<String, Integer> map) {
         return Collections.unmodifiableMap(map);
//        Set<Map.Entry<String, Integer>> entries = map.entrySet();
//        return Map.ofEntries(entries.toArray(new Map.Entry[0])) ;
    }

}
