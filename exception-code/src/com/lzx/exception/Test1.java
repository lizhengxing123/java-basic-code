package com.lzx.exception;

public class Test1 {
    public static void main(String[] args) {
        method1();
    }

    public static void method1() {
        System.out.println("----------method1----------");
        try {
            int[] arr = new int[10];
            System.out.println(arr[11]);
            int i = 10 / 0;
        } catch (ArithmeticException | StringIndexOutOfBoundsException e) {
            // 可以同时处理多个异常
            System.out.println("ArithmeticException | NullPointerException");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException");
        } catch (Exception e) {
            // 父类要写在最后
            System.out.println("Exception");
        }
    }
}
