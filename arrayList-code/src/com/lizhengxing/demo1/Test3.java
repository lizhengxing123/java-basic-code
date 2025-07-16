package com.lizhengxing.demo1;

import java.util.ArrayList;
import java.util.Scanner;

public class Test3 {
    public static void start() {
        Scanner sc = new Scanner(System.in);
        // 学生列表
        ArrayList<Student> students = new ArrayList<>();

        loop:
        while (true) {
            initMenu();
            System.out.println("请输入你的选择：");
            String choose = sc.next();
            switch (choose) {
                case "1" -> addStudent(students);
                case "2" -> deleteStudent(students);
                case "3" -> updateStudent(students);
                case "4" -> queryStudent(students);
                case "5" -> {
                    break loop;
                }
                default -> System.out.println("输入有误");
            }
        }
    }

    // 初始化菜单
    public static void initMenu() {
        System.out.println("欢迎使用学生管理系统");
        System.out.println("1、添加学生");
        System.out.println("2、删除学生");
        System.out.println("3、修改学生");
        System.out.println("4、查询学生");
        System.out.println("5、退出系统");
    }

    // 判断 id 是否存在，并返回所在索引
    public static int isExist(ArrayList<Student> students, String id) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    // 增
    public static void addStudent(ArrayList<Student> students) {
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        // 1、输入学生信息
        while (true) {
            System.out.println("请输入学生id：");
            String id = sc.next();
            if (isExist(students, id) != -1) {
                System.out.println("id已存在，请重新输入");
            } else {
                student.setId(id);
                break;
            }
        }

        updateStudentInfo(sc, student);

        students.add(student);
        System.out.println("学生信息添加成功");
    }

    // 删
    public static void deleteStudent(ArrayList<Student> students) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的学生id：");
        String id = sc.next();
        int index = isExist(students, id);
        if (index == -1) {
            System.out.println("id不存在");
        } else {
            students.remove(index);
            System.out.println("学生信息删除成功");
        }
    }

    // 改
    public static void updateStudent(ArrayList<Student> students) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的学生id：");
        String id = sc.next();
        int index = isExist(students, id);
        if (index == -1) {
            System.out.println("id不存在");
        } else {
            Student student = students.get(index);

            updateStudentInfo(sc, student);

            System.out.println("学生信息修改成功");
        }
    }

    // 查
    public static void queryStudent(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("学生列表为空,请添加学生后再查询");
            return;
        }
        // 表头
        System.out.println("id\t姓名\t年龄\t地址");
        for (Student student : students) {
            System.out.println(student.getId() + "\t" + student.getName() + "\t" + student.getAge() + "\t" + student.getAddress());
        }
    }

    // 学生信息修改
    public static void updateStudentInfo(Scanner sc, Student student) {
        System.out.println("请输入学生姓名：");
        String name = sc.next();
        student.setName(name);
        System.out.println("请输入学生年龄：");
        int age = sc.nextInt();
        student.setAge(age);
        System.out.println("请输入学生地址：");
        String address = sc.next();
        student.setAddress(address);

    }
}
