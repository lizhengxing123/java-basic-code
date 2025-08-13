package com.lzx.poker;

import java.util.ArrayList;
import java.util.Collections;

public class PokerGame3 {
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
    }

    public PokerGame3() {
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
        System.out.print(name + "的牌是：");
        for (String s : list) System.out.print(s + " ");
        System.out.println();
    }
}
