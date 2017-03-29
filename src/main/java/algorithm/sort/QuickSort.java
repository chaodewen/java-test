package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Cc on 2017/3/29.
 */

/**
 * 时间复杂度O(NlogN)~O(N^2)
 * 快速排序的基本思想是：每次从无序的序列中找出一个数作为中间点（可以把第一个数作为中间点）
 * 然后把小于中间点的数放在中间点的左边，把大于中间点的数放在中间点的右边
 * 对以上过程重复最好logN次、最差N次得到有序的序列
 * 快速排序是通常被认为在同数量级O(NlogN)的排序方法中平均性能最好的
 * 但若初始序列按关键码有序或基本有序时，快排序反而蜕化为冒泡排序
 * 为改进之，通常以“三者取中法”来选取基准记录
 * 即将排序区间的两个端点与中点三个记录关键码居中的调整为支点记录
 * 快速排序是一个不稳定的排序方法
 */
public class QuickSort {
    private static void quickSort(int arr[], int left, int right) {
        if (left < right) {
            int small = left, key = arr[right];

            for (int large = left; large < right; large ++)
                if (arr[large] <= key) // 感觉取等号的话是稳定排序
                    swap(arr, small ++, large);

            swap(arr, small, right);

            quickSort(arr, left, small - 1);
            quickSort(arr, small + 1, right);
        }
    }

    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // 检查排序函数正确性
        int N = 100;
        int[] arr = new int[N], testarr = new int[N];
        Random rand = new Random();

        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < N; j++) {
                arr[j] = rand.nextInt(100);
                testarr[j] = arr[j];
            }

            Arrays.sort(testarr);
            quickSort(arr, 0, N - 1);

            for (int j = 0; j < N; j++) {
                if (arr[j] != testarr[j]) {
                    System.out.println("Arrays.sort:");
                    for (int k = 0; k < N; k++)
                        System.out.print(testarr[k] + " ");

                    System.out.println();

                    System.out.println("QuickSort:");
                    for (int k = 0; k < N; k++)
                        System.out.print(arr[k] + " ");

                    System.out.println();

                    System.out.println("QuickSort Wrong!");

                    return;
                }
            }
        }

        System.out.println("QuickSort Right!");
    }
}