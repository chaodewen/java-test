package algorithm.collection;

import java.util.ArrayList;

/**
 * Created by Cc on 2017/4/15.
 */

// 暂时不保证正确
public class Heap {
    ArrayList<Integer> heap;
    boolean max;
    public Heap(boolean max) {
        this.max = max;
        heap = new ArrayList<Integer>();
    }
    public int size() {
        return heap.size();
    }
    public void offer(Integer i) {
        heap.add(i);
        for(int j = (heap.size() - 2) / 2; j >= 0; j --)
            heapify(heap, 0, heap.size());
    }
    public int peek() {
        return heap.get(0);
    }
    public int poll() {
        swap(heap, 0, heap.size() - 1);

        int ans = heap.remove(heap.size() - 1);

        heapify(heap, 0, heap.size());

        return ans;
    }
    private void heapify(ArrayList<Integer> nums, int root, int len) {
        int left = 2 * root + 1, right = 2 * root + 2, index = root;

        if(max) {
            if(left < len && nums.get(index) < nums.get(left))
                index = left;

            if(right < len && nums.get(index) < nums.get(right))
                index = right;
        }
        else {
            if(left < len && nums.get(index) > nums.get(left))
                index = left;

            if(right < len && nums.get(index) > nums.get(right))
                index = right;
        }

        if(index != root) {
            swap(nums, index, root);
            heapify(nums, index, len);
        }
    }
    private void buildHeap(ArrayList<Integer> nums, int len) {
        for(int i = (len - 2) / 2; i >= 0; i --)
            heapify(nums, len, i);
    }
    private void swap(ArrayList<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}