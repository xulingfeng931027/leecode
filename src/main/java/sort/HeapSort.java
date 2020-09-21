package sort;

/**
 * 堆排序实现
 *
 * @author 逼哥
 * @date 1/20/2020
 * @see tree.Heap
 */
public class HeapSort {
    private static void buildHeap(int[] nums, int count) {
        for (int i = count / 2; i >= 1; i--) {
            shiftDown(nums, count, i);
        }
    }

    public static void sort(int[] nums) {
        int n = nums.length - 1;
        buildHeap(nums, n);
        int k = n;
        while (k > 1) {
            int temp = nums[k];
            nums[k] = nums[1];
            nums[1] = temp;
            k--;
            shiftDown(nums, k, 1);
        }
    }


    /**
     * 下方堆化
     *
     * @param nums
     * @param count 数组最大长度
     * @param i     当前需要堆化的下标
     */
    private static void shiftDown(int[] nums, int count, int i) {
        while (true) {
            int maxPos = i;
            int j = i * 2;
            if (j <= count && nums[i] < nums[j]) {
                maxPos = i * 2;
            }
            //取左右子节点的较大值
            if (i * 2 + 1 <= count && nums[maxPos] < nums[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            int temp = nums[i];
            nums[i] = nums[maxPos];
            nums[maxPos] = temp;
            //记录上次的shiftDown后的下标
            i = maxPos;
        }
    }
}
