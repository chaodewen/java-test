package algorithm.sort;

/**
 * Created by Cc on 2017/3/31.
 */

public class HeapSort {
    // root为根节点坐标
    // 方法对root、left和right的三角关系进行调整
    // 这三个节点大小关系没问题时返回(不对更下层的节点进行调整)
    // 有问题时会一直调整到叶子
    private static void maxHeapify(int[] nums, int heapSize, int root) {
        int left = 2 * root + 1, right = root * 2 + 2, larger = root;

        if(left < heapSize && nums[left] > nums[root])
            larger = left;

        if(right < heapSize && nums[right] > nums[larger])
            larger = right;

        if(larger != root) {
            swap(nums, larger, root);
            maxHeapify(nums, heapSize, larger);
        }
    }
    // 建立大根堆,思想是:
    // 自底向上从最后一个非叶子节点起逐个调整i、left和right的三角关系
    private static void buildMaxHeap(int[] nums) {
        for(int i = (nums.length - 2) / 2; i >= 0; i --)
            maxHeapify(nums, nums.length, i);
    }
    // 大根堆并不是最终结果
    public static void heapSort(int[] nums) {
        buildMaxHeap(nums);
        for(int i = nums.length - 1; i > 0; i --) {
            swap(nums, 0, i); // 根顶最大元素跟数组最后一个元素换
            maxHeapify(nums, i, 0); // 从根节点开始调整三角关系
        }
    }
    private static void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };

        heapSort(arr);
//        maxHeapify(arr, arr.length, 0);
//        buildMaxHeap(arr, arr.length);

        for(int i = 0; i < arr.length; i ++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}