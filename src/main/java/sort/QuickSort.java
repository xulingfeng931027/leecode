package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author 逼哥
 * @date 2019/10/5
 */
public class QuickSort {

    /**
     * 选取arr[right]为分区点,将小于它的放左边,大于的放右边
     *
     * @param arr   待排序数组
     * @param left  左侧索引
     * @param right 右侧索引
     * @return 最终分区点索引位置
     */
    private static int partition(int[] arr, int left, int right) {
        //分区点的值
        int partitionValue = arr[right];
        int i = left;
        //找到分区点索引,并将大于分区点的值右移
        for (int j = left; j < right; j++) {
            if (arr[j] < partitionValue) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        //分区点的值跟索引所在值交换
        arr[right] = arr[i];
        arr[i] = partitionValue;
        //        System.out.println(Arrays.toString(arr));
        return i;
    }


    public void quickSort(int[] arr, int length) {
        quickSort0(arr, 0, length - 1);
    }

    private void quickSort0(int[] arr, int left, int right) {
        //递归退出条件
        if (left >= right) {
            return;
        }
        //获取分区点
        int q = partition(arr, left, right);

        quickSort0(arr, left, q - 1);
        quickSort0(arr, q + 1, right);
    }

    @Test public void quickSortTest() {
        int[] arr = { 4, 2,1, 5, 3 };
        quickSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
