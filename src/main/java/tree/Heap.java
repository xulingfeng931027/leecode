package tree;

import java.util.Arrays;

/**
 * 堆结构
 *
 * @author 逼哥
 * @date 2019/10/10
 */
public class Heap {
    private int[] nums;
    private int capacity;
    //已存储的个数
    private int count;

    public Heap(int capacity) {
        nums = new int[capacity + 1];
        this.capacity = capacity;
        count = 0;
    }

    public Heap(int[] nums) {
        this.nums = nums;
        this.capacity = nums.length - 1;
        count = nums.length;

    }

    public static void main(String[] args) {
//        Heap heap = new Heap(nums);
//        heap.insert(5);
//        heap.insert(10);
//        heap.insert(1);
//        heap.insert(4);
//        heap.insert(8);
//        heap.insert(11);
//        heap.insert(15);

        int[] nums = {99, 7, 5, 19, 8, 4, 1, 20, 13, 16};
//       buildHeap(nums,nums.length-1);
        sort(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void buildHeap(int[] nums, int count) {
        for (int i = count / 2; i >= 1; i--) {
            heapify(nums, count, i);
        }
    }

    public static void sort(int[] nums) {
        int n = nums.length - 1;
        buildHeap(nums, n);
        int k=n;
        while (k > 1) {
            int temp = nums[k];
            nums[k] = nums[1];
            nums[1] = temp;
            k--;
            heapify(nums, k, 1);
        }
    }





    /**
     * @param nums
     * @param count 数组最大长度
     * @param i     当前需要堆化的下标
     */
    private static void heapify(int[] nums, int count, int i) {
        while (true) {
            int maxPos = i;

            if (i * 2 <= count && nums[i] < nums[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= count && nums[maxPos] < nums[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            int temp = nums[i];
            nums[i] = nums[maxPos];
            nums[maxPos] = temp;
            i = maxPos;
        }
    }

    public int[] getNums() {
        return nums;
    }

    public void insert(int data) {
        if (count >= capacity) {
            return;
        }
        nums[++count] = data;
        int i = count;
        while (i / 2 > 0 && nums[i] > nums[i / 2]) {
            int temp = nums[i];
            nums[i] = nums[i / 2];
            nums[i / 2] = temp;
            i = i / 2;
        }
    }

    public void removeMax() {
        remove(1);
    }

    public void remove(int index) {
        if (count == 0) {
            return;
        }
        //将堆中最后一个元素挪到堆顶
        nums[index] = nums[count];
        nums[count--] = 0;
        //重新堆化
        heapify(nums, count, index);
    }

}
