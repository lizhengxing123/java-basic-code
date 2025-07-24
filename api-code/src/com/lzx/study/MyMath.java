package com.lzx.study;

public class MyMath {
    public static void main(String[] args) {
        // 1、绝对值 Math.abs
        System.out.println(Math.abs(-10));
        // 超出范围回有bug
        System.out.println(Math.abs(-2147483648)); // -2147483648
        // 使用最新的api，超出范围会报异常
        // System.out.println(Math.absExact(-2147483648)); // ArithmeticException

        // 2、向上取整 Math.ceil
        System.out.println(Math.ceil(-12.3)); // -12.0
        System.out.println(Math.ceil(12.3)); // 13.0

        // 3、向下取整 Math.floor
        System.out.println(Math.floor(-12.3)); // -13.0
        System.out.println(Math.floor(12.3)); // 12.0

        // 4、四舍五入 Math.round
        System.out.println(Math.round(-12.3)); // -12
        System.out.println(Math.round(-12.6)); // -13
        System.out.println(Math.round(12.3)); // 12
        System.out.println(Math.round(12.6)); // 13

        // 5、获取最值 Math.max Math.min
        System.out.println(Math.max(12, 34)); // 34
        System.out.println(Math.min(12, 34)); // 12

        // 6、幂函数 Math.pow
        System.out.println(Math.pow(2, 3)); // 8.0
        System.out.println(Math.pow(2, 0)); // 1.0
        System.out.println(Math.pow(4, 0.5)); // 2.0
        System.out.println(Math.pow(4, -0.5)); // 0.5

        // 7、随机数 Math.random
        System.out.println(Math.random()); // [0.0, 1.0)

        // 8、开方函数 Math.sqrt Math.cbrt
        System.out.println(Math.sqrt(4)); // 2.0
        System.out.println(Math.cbrt(8)); // 2.0

        System.out.println("-------------------------------");

        // 9、统计自幂数
        countSelfPowerNum(1);
        countSelfPowerNum(2);
        countSelfPowerNum(3);
        countSelfPowerNum(4);
        countSelfPowerNum(5);
        countSelfPowerNum(6);
        countSelfPowerNum(7);
        countSelfPowerNum(8);
        countSelfPowerNum(9);
        countSelfPowerNum(10);
    }

    // 统计自幂数
    // num 为位数
    private static int countSelfPowerNum(int num) {
        int count = 0;
        for (int i = (int) Math.pow(10, num - 1); i < (int) Math.pow(10, num); i++) {
            // 拿到数字的每一位
            int temp = i;
            int sum = 0;
            while (temp != 0) {
                int mod = temp % 10;
                sum += (int) Math.pow(mod, num);
                temp /= 10;
            }
            if (sum == i) {
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.println(num + "位数的自幂数有" + count + "个");
        return count;
    }
}
