package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Cc on 2017/3/31.
 */

public class SortTest {
    private static int[] getHeapSorted(int[] arr) {
        int[] testArr = new int[arr.length];

        for(int i = 0; i < arr.length; i ++)
            testArr = arr;

        HeapSort.heapSort(testArr, arr.length);

        return testArr;
    }
    private static int[] getQuickSorted(int[] arr) {
        int[] testArr = new int[arr.length];

        for(int i = 0; i < arr.length; i ++)
            testArr = arr;

        QuickSort.quickSort(testArr, 0, arr.length - 1);

        return testArr;
    }
    public static void main(String[] args) {
        // 检查排序函数正确性
        int N = 100;
        int[] arr = new int[N];
        Random rand = new Random();

        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < N; j++)
                arr[j] = rand.nextInt(100);

            Arrays.sort(arr);

            int[] testArr = getQuickSorted(arr);
//            int[] testArr = getHeapSorted(arr);

            for (int j = 0; j < N; j++) {
                if (arr[j] != testArr[j]) {
                    System.out.println("Arrays.sort:");
                    for (int k = 0; k < N; k++)
                        System.out.print(testArr[k] + " ");

                    System.out.println();

                    System.out.println("New Sort:");
                    for (int k = 0; k < N; k++)
                        System.out.print(arr[k] + " ");

                    System.out.println();

                    System.out.println("New Sort Wrong!");

                    return;
                }
            }
        }

        System.out.println("New Sort Right!");
    }
}