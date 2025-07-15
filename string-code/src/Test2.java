import java.util.StringJoiner;

public class Test2 {

    public static void main(String[] args) {
        // test1();
        // test2();
        // test3();
        // test4();
        // test5();
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.capacity());

        sb.append("123");
        sb.append("123");
        System.out.println(sb);
        System.out.println(sb.length());
        System.out.println(sb.capacity());
    }

    // 屏蔽手机号
    public static void test1() {
        String phone = "16792323333";
        String phone1 = phone.substring(0, 3) + "****" + phone.substring(7);
        System.out.println(phone1);
    }

    // 获取身份证信息
    public static void test2() {
        String idCard = "410323199910091234";
        String year = idCard.substring(6, 10);
        String month = idCard.substring(10, 12);
        if (month.charAt(0) == '0') {
            month = month.substring(1);
        }
        String day = idCard.substring(12, 14);
        if (day.charAt(0) == '0') {
            day = day.substring(1);
        }
        System.out.println(year + "年" + month + "月" + day + "日");

        // 获取性别
        int sex = idCard.charAt(16) - '0';
        System.out.println(sex);
        if (sex % 2 == 0) {
            System.out.println("女");
        } else {
            System.out.println("男");
        }
    }

    // 敏感词替换
    public static void test3() {
        String str = "你好，我是一个程序员";
        String str1 = str.replace("程序员", "***");
        System.out.println(str1);
    }

    // 新的类 StringBuilder
    public static void test4() {
        StringBuilder sb = new StringBuilder();

        // 添加
        sb.append("abc");
        sb.append(123);
        System.out.println(sb); // abc123

        // 插入
        sb.insert(2,  true);
        System.out.println(sb); // abtruec123

        // 反转
        sb.reverse();
        System.out.println(sb); // 321cba

        // 长度
        System.out.println(sb.length()); // 6

        // 转换为String
        System.out.println(sb.toString());
    }

    // 新的类 StringJoiner
    public static void test5() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");

        sj.add("123").add("456").add("789");

        System.out.println(sj);

        System.out.println(sj.length()); // 15表示字符个数

    }
}
