package com.lizhengxing.demo1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        loop:
        while (true) {
            System.out.println("请选择操作：1.注册 2.登录 3.忘记密码 4.退出");
            String choice = sc.next();
            switch (choice) {
                case "1" -> register(users, sc);
                case "2" -> login(users, sc);
                case "3" -> forgetPassword(users, sc);
                case "4" -> {
                    System.out.println("退出系统");
                    break loop;
                }
                default -> System.out.println("输入有误，请重新输入");
            }
        }
    }

    // 忘记密码
    private static void forgetPassword(ArrayList<User> users, Scanner sc) {
        // 输入用户名
        System.out.println("请输入用户名：");
        String username = sc.next();
        User user = getUserByUsername(users, username);
        if (user == null) {
            System.out.println("用户不存在，请先注册");
            return;
        }

        // 输入身份证号码
        System.out.println("请输入身份证号码：");
        String idCard = sc.next();
        // 输入手机号
        System.out.println("请输入手机号：");
        String phone = sc.next();
        // 判断身份证号码和手机号是否正确
        if (!(user.getIdCard().equalsIgnoreCase(idCard) && user.getPhone().equals(phone))) {
            System.out.println("身份证号码或手机号错误");
        }

        // 输入新密码
        while (true) {
            System.out.println("请输入新密码：");
            String password = sc.next();
            System.out.println("请再次输入新密码：");
            String password2 = sc.next();
            if (!password.equals(password2)) {
                System.out.println("两次密码不一致");
                continue;
            }
            user.setPassword(password);
            System.out.println("密码修改成功");
            break;
        }

    }

    // 登录
    private static void login(ArrayList<User> users, Scanner sc) {
        // 用户名
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入用户名：");
            String username = sc.next();
            User user = getUserByUsername(users, username);
            if (user == null) {
                System.out.println("用户名不存在");
                return;
            }
            // 密码
            System.out.println("请输入密码：");
            String password = sc.next();

            // 验证码
            while (true) {
                String code = generateCode();
                System.out.println("请输入验证码：" + code);
                String code2 = sc.next();
                if (!code.equalsIgnoreCase(code2)) {
                    System.out.println("验证码错误，请重新输入");
                    continue;
                }
                break;
            }

            // 判断用户名和密码是否正确
            if (user.getPassword().equals(password)) {
                System.out.println("登录成功");
                Test3 test3 = new Test3();
                Test3.start();
                break;
            } else {
                if (2 - i > 0) {
                    System.out.println("账号或密码错误，请重新输入，您还剩" + (2 - i) + "次机会");
                } else {
                    System.out.println("登录失败");
                }
            }
        }
    }

    // 注册
    private static void register(ArrayList<User> users, Scanner sc) {
        User user = new User();
        // 输入用户名
        while (true) {
            System.out.println("请输入用户名：");
            String username = sc.next();

            if (!checkUsername(username)) {
                System.out.println("用户名格式错误");
                continue;
            }
            if (getUserByUsername(users, username) != null) {
                System.out.println("用户名已存在");
                continue;
            }

            user.setUsername(username);
            break;
        }

        // 输入密码
        while (true) {
            System.out.println("请输入密码：");
            String password = sc.next();
            System.out.println("请再次输入密码：");
            String password2 = sc.next();

            if (!password.equals(password2)) {
                System.out.println("两次密码不一致");
                continue;
            }

            user.setPassword(password);
            break;
        }

        // 输入身份证号码
        while (true) {
            System.out.println("请输入身份证号码：");
            String idCard = sc.next();

            if (!checkIdCard(idCard)) {
                System.out.println("身份证号码格式错误");
                continue;
            }

            user.setIdCard(idCard);
            break;
        }

        // 输入手机号
        while (true) {
            System.out.println("请输入手机号：");
            String phone = sc.next();

            if (!checkPhone(phone)) {
                System.out.println("手机号格式错误");
                continue;
            }

            user.setPhone(phone);
            break;
        }

        System.out.println("注册成功: " + user.getUsername() + " " + user.getPassword() + " " + user.getIdCard() + " " + user.getPhone());
        users.add(user);
    }

    // 根据用户名查询用户
    private static User getUserByUsername(ArrayList<User> users, String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    // 校验用户名
    private static boolean checkUsername(String username) {
        // 3-15位，只能是字母和数字，不能为纯数字
        /*// 正则表达式
        if (username.matches("[0-9]{3,15}")) {
            return false;
        }
        if (!username.matches("[a-zA-Z0-9]{3,15}")) {
            return false;
        }*/

        if (username.length() < 3 || username.length() > 15) {
            return false;
        }
        // 统计数字个数
        int count = 0;
        // 遍历字符串
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            // 不是字母或数字，返回false
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
            if (Character.isDigit(c)) {
                count++;
            }
        }
        // 判断是否是纯数字
        return count != username.length();
    }

    // 校验身份证号码
    private static boolean checkIdCard(String idCard) {
        // 正则表达式
        // return idCard.matches("\\d{17}[0-9Xx]");

        // 18位，前17位是数字，最后一位是数字或X
        if (idCard.length() != 18) {
            return false;
        }
        // 第一位不能为0
        if (idCard.charAt(0) == '0') {
            return false;
        }
        // 前17位是数字
        for (int i = 0; i < 17; i++) {
            char c = idCard.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return idCard.charAt(17) == 'X' || idCard.charAt(17) == 'x' || Character.isDigit(idCard.charAt(17));
    }

    // 校验手机号
    private static boolean checkPhone(String phone) {
        // 正则表达式
        // return phone.matches("1[3-9]\\d{9}");
        // 11位，第一位是1，第二位是3-9，后面是0-9
        if (phone.length() != 11) {
            return false;
        }
        if (phone.charAt(0) != '1') {
            return false;
        }
        for (int i = 1; i < 11; i++) {
            char c = phone.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    // 生成验证码
    private static String generateCode() {
        // 4个字母，1个数字
        byte[] bytes = new byte[5];

        Random r = new Random();

        for (int i = 0; i < 4; i++) {
            int type = r.nextInt(2);
            if (type == 0) {
                // 大写字母 A-Z 65-90
                bytes[i] = (byte) (r.nextInt(26) + 65);
            } else {
                // 小写字母 a-z 97-122
                bytes[i] = (byte) (r.nextInt(26) + 97);
            }
        }

        // 数字 0-9 48-57
        byte num = (byte) (r.nextInt(10) + 48);
        // 随机生成一个要交换的位置
        int index = r.nextInt(5);
        // 交换
        byte temp = bytes[index];
        bytes[4] = temp;
        bytes[index] = num;

        return new String(bytes);
    }
}
