package algorithm.sort;

/**
 * Created by Cc on 2017/4/3.
 */

public class MergeSort {
    // from[]的[start, mid]和[mid+1, end]进行归并,结果存放在to[]中
    private static void merge(int[] from, int[] to, int start, int mid, int end) {
        int i = start, j = mid + 1, k = start;

        while(i <= mid && j <= end) {
            if(from[i] <= from[j])
                to[k ++] = from[i ++];
            else
                to[k ++] = from[j ++];
        }

        while(i <= mid)
            to[k ++] = from[i ++];

        while(j <= end)
            to[k ++] = from[j ++];
    }
    // 2-路归并排序，将序列划分为每个数一组，两两合并为顺序，合并后组数减少组内数字个数增加
    // 递归调用得到结果存放在to[]中
    // 归并排序算法比较占用内存，但却是效率高且稳定的排序算法
    // 最好、最坏和平均时间复杂度都是O(NlogN)
    public static void mergeSort(int[] from, int[] to, int start, int end) {
        if(start == end)
            to[start] = from[start];
        else {
            int mid = (end - start) / 2 + start;
            int[] temp = new int[from.length];
            mergeSort(from, temp, start, mid);
            mergeSort(from, temp, mid + 1, end);
            merge(temp, to, start, mid, end);
        }
    }
}