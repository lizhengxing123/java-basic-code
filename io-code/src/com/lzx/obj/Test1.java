package com.lzx.obj;

import java.io.*;
import java.util.ArrayList;

public class Test1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // method1();
        method2();
    }

    public static void method1() throws IOException {
        System.out.println("--------------method1--------------");
        Student s1 = new Student("张三", "男", 18, 70.0);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("io-code\\b.txt"));
        oos.writeObject(s1);
        oos.close();
    }

    public static void method2() throws IOException, ClassNotFoundException {
        System.out.println("--------------method2-------------");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("io-code\\b.txt"));
        Student s2 = (Student) ois.readObject();
        System.out.println(s2);
        ois.close();
    }

    // 如果要序列化多个对象，放到一个集合中即可
    public static void method3() throws IOException, ClassNotFoundException {
        System.out.println("--------------method3-------------");
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("张三", "男", 18, 70.0));
        list.add(new Student("李四", "男", 19, 75.0));
        list.add(new Student("王五", "男", 20, 80.0));

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("io-code\\c.txt"));
        oos.writeObject(list);
        oos.close();
    }
    public static void method4() throws IOException, ClassNotFoundException {
        System.out.println("--------------method4-------------");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("io-code\\c.txt"));
        ArrayList<Student> list = (ArrayList<Student>) ois.readObject();
        System.out.println(list);
        ois.close();
    }
}
