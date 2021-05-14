package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author 逼哥
 * @date 2019/10/5
 */
public class QuickSort2 {


    public void quickSort(int[] arr) {
        quickSort0(arr, 0, arr.length - 1);
    }

    public void quickSort0(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int point = partition(arr, lo, hi);
        quickSort0(arr, lo, point - 1);
        quickSort0(arr, point + 1, hi);
    }

    private int partition(int[] arr, int lo, int hi) {
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (arr[j] < arr[hi]) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr,i, hi);
        return i;
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    @Test
    public void quickSortTest() {
        int[] arr = {1, 7, 6, 3, 9,2,8,5, 4};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
