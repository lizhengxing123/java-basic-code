package com.lzx.demo1;

import java.util.Random;

public class OperatorTest {
    public static void main(String[] args) {
//        System.out.println("请输入三位整数：");
//
//        Scanner scanner = new Scanner(System.in);
//
//        int num = scanner.nextInt();
//
//        // 将数字拆分成三个数字，分别对应个、十、百位,并分别打印
//        System.out.println("个位数：" + num % 10);
//        System.out.println("十位数：" + num / 10 % 10);
//        System.out.println("百位数：" + num / 100);
//        byte a = 100;
//        byte b = 30;
//        byte c = (byte)(a + b);
//        System.out.println(c);
//        System.out.println('a' + 10); // 107
//        System.out.println('a' + 'b'); // 196
//        System.out.println('a' + "abc"); // aabc
//        int a = 10;
//        int b = ++a;
//        System.out.println(a);
//        System.out.println(b);

//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("请输入你的时髦度（0-10）：");
//        int a = sc.nextInt();
//
//        System.out.println("请输入女孩的时髦度（0-10）：");
//        int b = sc.nextInt();
//
//        if (a > b) {
//            System.out.println("相亲成功");
//        } else {
//            System.out.println("相亲失败");
//        }

        /*int a = 10;
        int b = 17;
        boolean c = a == 6 || b == 6 || (a + b) % 6 == 0;
        int d = a > b ? a : b;
        System.out.println(c);
        System.out.println(a);
        System.out.println(b);
        System.out.println(d);*/

        /*switch (num) {
            case 1,2,3,4,5 -> System.out.println("工作日");
            case 6,7 -> System.out.println("休息日");
        }*/
        /*String sum = "";
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                sum = sum + i + " ";
            }
        }
        System.out.println(sum);*/

        /*double height = 8844.43 * 1000;

        double paper = 0.1;

        int count = 0;

        while (paper < height) {
            paper *= 2;
            count++;
        }

        System.out.println("折叠了" + count + "次");
        System.out.println("折叠之后的纸张厚度为：" + paper / 1000 + "米");*/

        /*int num = 10086;
        // 判断 num 是否为回文数
        int temp = num;
        int reversedNum = 0;
        while (temp != 0) {
            int digit = temp % 10;
            reversedNum = reversedNum * 10 + digit;
            temp /= 10;
        }
        System.out.println(reversedNum);*/

        // 0-100 缝7过
        /*for (int i = 0; i <= 100; i++) {
            if (i % 7 == 0 || i % 10 == 7 || i / 10 == 7) {
                System.out.println(i);
            }
        }*/

        /*int num = 19;

        int res = 1;

        while (res <= num) {
            if(res * res == num) {
                System.out.println(res);
                break;
            }
            if(res * res > num) {
                System.out.println(res - 1);
                break;
            }
            res++;
        }*/

        // 判断一个数是否为质数
        /*boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }*/

        // 生成一个随机数
        /*int randomNum = (int) (Math.random() * 100) + 1;
        System.out.println("随机数为：" + randomNum);*/
        // 使用 Random 类生成随机数
        Random random = new Random();
        int randomNum = random.nextInt(100) + 1;
        System.out.println("随机数为：" + randomNum);
        int start = 1, end = 100;
        while (true) {
            int guessNum = (start + end) / 2;
            System.out.println("猜的数字" + guessNum);
            if (guessNum == randomNum) {
                System.out.println("恭喜你，猜中了！" + guessNum);
                break;
            }
            if (guessNum > randomNum) {
                System.out.println("猜大了");
                end = guessNum - 1;
            } else {
                System.out.println("猜小了");
                start = guessNum + 1;
            }
        }
    }
}
