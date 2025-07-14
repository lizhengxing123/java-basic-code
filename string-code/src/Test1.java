public class Test1 {
    public static void main(String[] args) {
        // test1();
        // test2();
        // test3();
        // test4();
         test5();
    }

    // 1、字符串初始化及比较
    public static void test1() {
        // 创建字符串
        // 1、直接写，会放在串池中
        String str0 = "hello";
        String str1 = "hello";
        System.out.println(str0 == str1); // true

        // 2、使用构造函数，会放在堆中
        String str2 = new String(); // 空字符串
        System.out.println(str2);

        // 3、使用字符数组
        char[] chars = {'H', 'e', 'l', 'l', 'o'};
        String str3 = new String(chars);
        System.out.println(str3); // Hello

        // 4、使用字节数组
        byte[] bytes = {72, 101, 108, 108, 111};
        String str4 = new String(bytes);
        System.out.println(str4); // Hello

        // str3和str4的地址值不同
        System.out.println(str3 == str4); // false

        // 比较字符串内容
        System.out.println(str3.equals(str4)); // true

        // 忽略大小写比较
        System.out.println(str3.equalsIgnoreCase(str1)); // true

        // 改变 chars 和 bytes 数组中的元素
        // str3 和 str4 不会改变
        chars[0] = 'h';
        bytes[0] = 97;
        System.out.println(str3); // Hello
        System.out.println(str4); // Hello

        System.out.println(new String(chars)); // hello
        System.out.println(new String(bytes)); // aello
    }

    // 2、字符串遍历
    public static void test2() {
        String str = "mac笔记本";

        for (int i = 0; i < str.length(); i++) {
            System.out.println((i + 1) + ":" + str.charAt(i));
        }
    }

    // 3、字符串反转
    public static void test3() {
        String str = "mac笔记本";
        String newStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            newStr += str.charAt(i);
        }
        System.out.println(newStr);
    }

    // 4、统计字符串中各种类型出现的次数
    public static void test4() {
        // 大写字母：65-90
        // 小写字母：97-122
        String str = "Hello World! 123";
        int num = 0;
        int upper = 0;
        int lower = 0;
        int other = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                upper++;
            }else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                lower++;
            }else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                num++;
            } else {
                other++;
            }
        }
        System.out.println("大写字母：" + upper);
        System.out.println("小写字母：" + lower);
        System.out.println("数字：" + num);
        System.out.println("其他字符：" + other);
    }

    // 5、将数字转换成中文写法
    public static void test5() {
        String[] numStr = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        String[] unitStr = {"", "十", "百", "千", "万", "十", "百", "千", "亿"};
        String str = "3125";
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            newStr += numStr[num] + unitStr[str.length() - 1 - i];
        }
        System.out.println(newStr);
    }
}
