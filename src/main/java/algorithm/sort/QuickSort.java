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
    public static void quickSort(int arr[], int left, int right) {
        if (left < right) {
            int i = left, key = arr[right];

            for (int j = left; j < right; j ++)
                if (arr[j] <= key) // 感觉取等号的话是稳定排序
                    swap(arr, i ++, j); // i指向当前最左边一个比key大的数,j指向当前比key大数的下一个比key小的数

            swap(arr, i, right);

            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }
    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}