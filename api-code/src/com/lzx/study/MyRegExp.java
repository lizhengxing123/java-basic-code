package com.lzx.study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyRegExp {
    public static void main(String[] args) {
        // 校验qq，6-20位数字，不能0开头
        String reg1 = "^[1-9]\\d{5,19}$";
        System.out.println("123456".matches(reg1)); // true
        System.out.println("0123456".matches(reg1)); // false

        // 匹配a-d或者m-p的字符
        String reg2 = "[a-dm-p]";
        System.out.println("a".matches(reg2)); // true
        System.out.println("z".matches(reg2)); // false

        // 取交集 相当于 [e-z]
        String reg3 = "[a-z&&[^a-d]]";
        System.out.println("a".matches(reg3)); // false
        System.out.println("z".matches(reg3)); // true

        // 忽略大小写 (?i)
        System.out.println("A".matches("a")); // false
        System.out.println("A".matches("(?i)a")); // true

        // 匹配长串 匹配 javaXX 忽略大小写
        // 方式1
        // Pattern p = Pattern.compile("(?i)JAVA\\d{0,2}");
        // 方式2
        // Pattern p = Pattern.compile("JAVA\\d{0,2}", Pattern.CASE_INSENSITIVE);
        // 方式3
        // 匹配 java8、11、18 但是只显示java
        // ?：是占位符，表示前面的字符
        // =：表示后面跟随的数据
        // 在获取的时候，只获取?所代表的字符
        // Pattern p = Pattern.compile("(JAVA)(?=8|11|18)", Pattern.CASE_INSENSITIVE);
        // 方式4
        // ?：是占位符，表示前面的字符
        // :：表示后面跟随的数据
        // 在获取的时候，会获取全部
        // Pattern p = Pattern.compile("(JAVA)(?:8|11|18)", Pattern.CASE_INSENSITIVE);
        // 方式5
        // ?：是占位符，表示前面的字符
        // !：表示不要后面跟随的这些数据
        // 在获取的时候，只获取?所代表的字符
        Pattern p = Pattern.compile("(JAVA)(?!8|11|18)", Pattern.CASE_INSENSITIVE);

        String str = "JaVa是一门编程语言，常用的是java8和JAVa11，目前版本是Java18，之后还会出现JAVA21";

        // 匹配器
        Matcher m = p.matcher(str);

        // 查找所有匹配项
        while (m.find()) {
            System.out.println(m.group()); // Java Java18 java21
        }

        // 贪婪爬取
        // Pattern p1 = Pattern.compile("ab+");
        // 非贪婪爬取
        Pattern p1 = Pattern.compile("ab+?");

        String str1 = "abbbbaaa";

        Matcher m1 = p1.matcher(str1);

        while (m1.find()) {
            System.out.println(m1.group()); // abbb
        }

        System.out.println("abc".replace("ab", "cd")); // cdc


        // 捕获分组
        // 按照左括号的顺序，从1开始递增
        // 内部使用 \\1 ,外部使用 $1
        // (.)：第1组，匹配任意字符
        // \\1+：第1组的内容出现1次及以上
        // $1： 在外面使用第1组的内容
        System.out.println("aaabbbcccde".replaceAll("(.)\\1+", "$1")); // abcde

    }
}
