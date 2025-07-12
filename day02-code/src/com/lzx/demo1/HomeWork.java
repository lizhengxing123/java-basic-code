package com.lzx.demo1;

import java.util.Random;
import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        // 1、卖机票
        // sellTicket();
        // 2、寻找101-200之间的质数
        // findPrimes(101, 200);
        // 3、生成验证码
        // System.out.println(generateVerificationCode());
        // 5、评委打分
        // System.out.println(score());
        // 6、加密
        // System.out.println(encrypt(1983));
        // 7、解密
        // System.out.println(decrypt(8346));
        // 8、抽奖
        // lottery();
        // 9、双色球中奖模拟
        lottery2();
    }

    // 1、卖机票
    public static void sellTicket() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入机票价格：");
        int price = sc.nextInt();
        System.out.println("请输入月份（1-12）：");
        int month = sc.nextInt();
        System.out.println("请输入经济舱（1）/头等舱（2）：");
        int type = sc.nextInt();

        // 淡季（11-4月）头等舱7折，经济舱6.5折
        if (month >= 11 || month <= 4) {
            if (type == 1) {
                System.out.println("淡季经济舱机票价格为：" + price * 0.65);
            } else if (type == 2) {
                System.out.println("淡季头等舱机票价格为：" + price * 0.7);
            }
        }
        // 旺季（5-10月）头等舱9折，经济舱8.5折
        if (month >= 5 && month <= 10) {
            if (type == 1) {
                System.out.println("旺季经济舱机票价格为：" + price * 0.85);
            } else if (type == 2) {
                System.out.println("旺季头等舱机票价格为：" + price * 0.9);
            }
        }
    }

    // 2、寻找范围内的质数
    public static void findPrimes(int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                count++;
                System.out.print(i + " ");
            }
        }
        System.out.println();
        System.out.println("共" + count + "个质数");
    }

    // 2.1、判断一个数是否为质数
    public static boolean isPrime(int num) {
        boolean flag = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    // 3、生成验证码
    public static String generateVerificationCode() {
        String code = "";
        Random rand = new Random();
        // 5位验证码，前四位为大写字母或者小写字母，最后一位为数字
        for (int i = 0; i < 4; i++) {
            // 0：大写字母，1：小写字母，2：数字
            int type = rand.nextInt(2);
            code += type == 0 ? generateRandomChar(65, 90) : generateRandomChar(97, 122);
        }
        code += generateRandomChar(48, 57);
        return code;
    }

    // 3.1、生成一个随机的字符
    public static char generateRandomChar(int start, int end) {
        // 将数字转成ASCII字符
        // 0-9：48-57
        // A-Z：65-90
        // a-z：97-122
        Random rand = new Random();
        int num = rand.nextInt(end - start + 1) + start;
        return (char) num;
    }

    // 4、复制数组
    public static void copyArray(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
    }

    // 5、评委打分
    public static int score() {
        Random rand = new Random();
        int[] arr = new int[6];
        for (int i = 0; i < arr.length; i++) {
            int num = rand.nextInt(101);
            arr[i] = num;
        }
        // 去掉最高分和最低分
        int max = arr[0];
        int min = arr[0];
        System.out.print(arr[0] + " ");
        for (int i = 1; i < 6; i++) {
            max = arr[i] > max ? arr[i] : max;
            min = arr[i] < min ? arr[i] : min;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        // 计算平均分
        int sum = 0;
        for (int j : arr) {
            if (j != max && j != min) {
                sum += j;
            }
        }
        return sum / 4;
    }

    // 6、加密
    public static int encrypt(int num) {
        // 获取数字的每一位，并存储到数组中
        int[] digits = getDigits(num);
        // 每一位 +5 %10
        for (int i = 0; i < digits.length; i++) {
            digits[i] = (digits[i] + 5) % 10;
        }
        // 反转数组
        reverseArray(digits);
        // 生成新数字
        return arrayToNum(digits);
    }

    // 6.1、获取数字的每一位，并存储到数组中
    public static int[] getDigits(int num) {
        // 计算整数的个数
        int count = 0;
        int temp = num;
        while (temp != 0) {
            temp /= 10;
            count++;
        }

        // 创建数组
        int[] digits = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = num % 10;
            num /= 10;
        }
        return digits;
    }

    // 6.2、数组反转
    public static void reverseArray(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    // 6.3、将数组中的每一位数字拼接成整数
    public static int arrayToNum(int[] arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num = num * 10 + arr[i];
        }
        return num;
    }

    // 7、解密
    public static int decrypt(int num) {
        // 获取数字的每一位，并存储到数组中
        int[] digits = getDigits(num);

        // 反转
        reverseArray(digits);
        // 还原
        for (int i = 0; i < digits.length; i++) {
            // 由于是先+5，再%10的
            // 所以，取余前每一个数最大为14，最小为5
            // 5-9 先取余即原数，再-5即可
            // 0-4 先取余需+10，再-5即可
            if (digits[i] >= 5 && digits[i] <= 9) {
                digits[i] = digits[i] - 5;
            } else {
                digits[i] = digits[i] + 10 - 5;
            }
        }
        // 生成解密的数
        return arrayToNum(digits);
    }

    // 8、数组抽奖，顺序随机且不重复
    public static void lottery() {
        int[] arr = {2, 588, 1000, 8888, 10000};
        // 已经出现过的数组
        int[] arr2 = new int[arr.length];
        int idx = 0;
        // 随机数
        Random rand = new Random();
        while (arr2[arr2.length - 1] == 0) {
            int i = rand.nextInt(arr.length);
            int num = arr[i];
            if (!isInArray(num, arr2)) {
                // 没出现过，打印
                System.out.println("抽中大奖" + num + "元");
                // 并增加到已出现的数组中
                arr2[idx] = num;
                idx++;
            }
        }
    }

    // 8.1、判断一个数是否在数组中
    public static boolean isInArray(int num, int[] arr) {
        boolean flag = false;
        for (int i : arr) {
            if (num == i) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    // 9、双色球中奖模拟
    public static void lottery2() {
        // 红球：1-33，6个，不能重复
        // 蓝球：1-16，1个，不能重复
        // 生成中奖号码
        int[] win = generateWinningNumbers();
        // 生成自己购买的号码
        int[] my = generateWinningNumbers();
        // 获取红色球中奖个数
        int redCount = countInArray(copyArray(my, 0, 5), copyArray(win, 0, 5));
        // 获取蓝色球中奖个数
        int blueCount = my[my.length - 1] == win[win.length - 1] ? 1 : 0;
        System.out.println(redCount);
        System.out.println(blueCount);
    }

    // 9.1、生成中奖号码
    public static int[] generateWinningNumbers() {
        int[] nums = new int[7];
        Random rand = new Random();
        for (int i = 0; i < nums.length; ) {
            int num = rand.nextInt(33) + 1;
            if (!isInArray(num, nums)) {
                nums[i] = num;
                i++;
            }
            if (i == nums.length - 1) {
                nums[i] = rand.nextInt(16) + 1;
            }
        }
        printArray(nums);
        return nums;
    }

    // 9.2、判断一个数组中的元素有几个在另一个数组中
    public static int countInArray(int[] arr1, int[] arr2) {
        int count = 0;
        for (int i : arr1) {
            if (isInArray(i, arr2)) {
                count++;
            }
        }
        return count;
    }

    // 9.3、拷贝数组，指定索引，前后都包括
    public static int[] copyArray(int[] arr, int start, int end) {
        int[] newArr = new int[end - start + 1];
        for (int i = start; i <= end; i++) {
            newArr[i - start] = arr[i];
        }
        return newArr;
    }

    // 打印数组的每一位数
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}
