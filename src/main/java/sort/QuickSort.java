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

    private int partition2(int[] arr, int low, int high) {
        if (low == high) {
            return low;
        }
        // 左指针从第一个
        int i = low;
        //分区基准取最右边的数
        for (int j = low; j < high; j++) {
            if (arr[j] < arr[high]) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);
        return i; // 返回tmp的正确位置
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
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
        int q = partition2(arr, left, right);

        quickSort0(arr, left, q - 1);
        quickSort0(arr, q + 1, right);
    }

    @Test
    public void quickSortTest() {
        int[] arr = {1, 7, 6, 3, 5, 4};
        quickSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
