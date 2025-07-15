import java.util.Random;

public class Test3 {

    public static void main(String[] args) {
        System.out.println(intStrToRoman("91"));
        System.out.println(test("abcde", "cdeab"));
        System.out.println(test2("abcdefghijklmnopqrstuvwxyz"));
        System.out.println(multiply("100", "10"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }

    // 将数字字符串变为罗马数字
    public static String intStrToRoman(String str) {
        // 定义对应数组
        String[] roman = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        // 定义结果字符串
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            res.append(roman[str.charAt(i) - '0']);
        }

        return res.toString();
    }

    // 字符串旋转匹配
    public static boolean test(String s1, String s2) {
        for (int i = 0; i < s2.length(); i++) {
            s1 = s1.substring(1) + s1.charAt(0);
            if (s2.equals(s1)) {
                return true;
            }
        }

        return false;
    }

    // 打乱字符串
    public static String test2(String str) {
        Random r = new Random();
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
            int index = r.nextInt(arr.length - 1 - i) + i + 1;
            // System.out.println(arr.length - 1 - i + "-" + i + "-" + index);
            char temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        return new String(arr);
    }

    // 计算两个字符串数字的乘积
    public static String multiply(String num1, String num2) {
        int n1 = strToInt(num1);
        int n2 = strToInt(num2);
        return intToStr(n1 * n2);
    }

    // 将字符串转为数字
    public static int strToInt(String str) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            res = res * 10 + (str.charAt(i) - '0');
        }
        return res;
    }
    // 将数字转为字符串
    public static String intToStr(int num) {
        StringBuilder res = new StringBuilder();
        while(num != 0) {
            res.insert(0, num % 10);
            num /= 10;
        }
        return res.toString();
    }
    // 计算最后一个单词的长度
    public static int lengthOfLastWord(String s) {
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (len != 0) {
                    break;
                }
            } else {
                len++;
            }
        }
        return len;
    }
}
