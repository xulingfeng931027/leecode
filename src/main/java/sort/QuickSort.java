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

    private int partition(int[] arr, int low, int high) {
        // 左指针从第二个数开始
        int i = low + 1;
        int j = high;
        int temp = arr[low];
        while (true) {
            // 找到左侧第一个不小于arr[low]的元素
            while (arr[i] < temp) {
                i++;
                if (i == high) {
                    break;
                }
            }
            //  找到右侧第一个不大于arr[low]的元素
            while (arr[j] > temp) {
                //由于temp是low j不可能等于low
                j--;
            }
            //当指针相遇了就终止
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
        }
        swap(arr, low, j);
        return j; // 返回tmp的正确位置
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
        int q = partition(arr, left, right);

        quickSort0(arr, left, q - 1);
        quickSort0(arr, q + 1, right);
    }

    @Test
    public void quickSortTest() {
        int[] arr = {4, 2, 1, 11, 9, 5, 3, 7};
        quickSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
