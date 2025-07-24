import java.util.Arrays;

public class MyArrays {
    public static void main(String[] args) {
        int[] arr = {3, 36, 1, 12, 55, 4};
        Integer[] arr2 = {12, 67, 62, 98, 34, 65, 1, 12};
        System.out.println(Arrays.toString(arr));
        // 降序排序
        Arrays.sort(arr2, (a, b) -> b - a);
        System.out.println(Arrays.toString(arr2));

        // method1();
        System.out.println("abc".compareTo("abcd"));
        System.out.println(method2(1));
    }

    public static void method1() {
        int[] arr = {3, 36, 1, 12, 55, 4};
        System.out.println(Arrays.toString(arr));
        // 升序排序
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 猴子吃桃
    public static int method2(int day) {
        if (day == 10) return 1;
        return (method2(day + 1) + 1) * 2;
    }

    // 爬楼梯 三种爬法 123
    public static int method3(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;

        // 优化空间
        int a = 1;
        int b = 2;
        int c = 4;
        for (int i = 4; i <= n; i++) {
            int temp = a + b + c;
            a = b;
            b = c;
            c = temp;
        }
        return c;
    }
}
