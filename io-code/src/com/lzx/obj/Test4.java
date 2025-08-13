package com.lzx.obj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Test4 {
    public static void main(String[] args) {
        ArrayList<Student> list = getList();
        System.out.println(list);
        Double[] weightList = getWeightList(list);
        System.out.println(Arrays.toString(weightList));

        System.out.println("-----------------");

        for (int i = 0; i < 3; i++) {
            System.out.println("---------------------第" + (i + 1) + "轮--------------------");
            // 获取随机到的学生
            int randomIndex = getRandomIndex(weightList);
            Student student = list.get(randomIndex);
            System.out.println(student);
            // 将其权重减半
            student.setWeight(student.getWeight() / 2);
            // 查看学生列表
            System.out.println(list);
            // 重新计算权重列表
            weightList = getWeightList(list);
            System.out.println(Arrays.toString(weightList));
            System.out.println("---------------------第" + (i + 1) + "轮结束--------------------");
        }

    }

    // 生成10个学生对象，并放到一个集合中
    public static ArrayList<Student> getList() {
        ArrayList<Student> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(new Student("张三" + i, i % 2 == 0 ? "男" : "女", 18 + i, 1));
        }
        return list;
    }

    // 根据集合计算每个学生的权重占比，并生成权重列表
    public static Double[] getWeightList(ArrayList<Student> list) {
        Double[] weightList = new Double[list.size()];
        double totalWeight = 0;
        for (Student student : list) {
            totalWeight += student.getWeight();
        }
        for (int i = 0; i < list.size(); i++) {
            weightList[i] = list.get(i).getWeight() / totalWeight;
        }
        // 格式化权重列表，保留两位小数
        for (int i = 1; i < weightList.length; i++) {
            weightList[i] += weightList[i - 1];
        }
        return weightList;
    }

    // 生成随机数，根据权重进行获取
    public static int getRandomIndex(Double[] weightList) {
        // 二分查找
        double random = Math.random();
        System.out.println(random);
        int index = Arrays.binarySearch(weightList, random);
        return index < 0 ? -index - 1 : index;
    }
}
