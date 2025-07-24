import java.util.Random;

public class MySort {
    public static void main(String[] args) {
        //int[] arr = {11, 3, 5, 7, 9, 2, 4, 6, 8, 10};
        // bubbleSort(arr);
        // selectionSort(arr);
        // insertionSort(arr);
        // System.out.println(Arrays.toString(arr));
        // System.out.println(getSum(100));
        int[] arr = new int[1000000];

        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt();
        }

        long start = System.currentTimeMillis();
        //bubbleSort(arr);
        quickSort1(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis();
//        printArray(arr);
        System.out.println(end - start);
    }

    // 打印数组
    public static void printArray(int[] arr) {
        if (arr == null) return;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        for (int i = arr.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        for (int j = 0; j < arr.length - 1; j++) {
            /*for (int i = j + 1; i <= arr.length - 1; i++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }*/
            // 优化 只需要交换一次
            int minIndex = j;
            for (int i = j + 1; i < arr.length; i++) {
                if (arr[minIndex] > arr[i]) {
                    minIndex = i;
                }
            }
            if (minIndex != j) {
                int temp = arr[j];
                arr[j] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                // 只要小，就不断地往前换
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }

    public static int getSum(int num) {
        if (num == 1) return 1;
        return num + getSum(num - 1);
    }

    // 阶乘
    public static int getFactorial(int num) {
        if (num == 1) return 1;
        return num * getFactorial(num - 1);
    }

    // 斐波那契
    public static int getFibonacci(int num) {
        if (num == 1 || num == 2) return 1;
        return getFibonacci(num - 1) + getFibonacci(num - 2);
    }

    // 快速排序
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int i = left;
        int j = right;
        int pivot = arr[left];
        while (i < j) {
            while (i < j && arr[j] >= pivot) j--;
            arr[i] = arr[j];
            while (i < j && arr[i] <= pivot) i++;
            arr[j] = arr[i];
        }
        arr[i] = pivot;
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    public static void quickSort1(int[] arr, int i, int j) {
        if (i >= j) return;

        int pivot = arr[i];

        int start = i;
        int end = j;

        while (start != end) {
            while (true) {
                // 从后往前找
                if (start >= end || arr[end] < pivot) {
                    break;
                }
                end--;
            }

            while (true) {
                // 从前往后找
                if (start >= end || arr[start] > pivot) {
                    break;
                }
                start++;
            }

            // 交换
            if (start != end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }

        // 基准数归位
        arr[i] = arr[start];
        arr[start] = pivot;

        // 递归
        quickSort1(arr, i, start - 1);
        quickSort1(arr, start + 1, j);


    }


}
