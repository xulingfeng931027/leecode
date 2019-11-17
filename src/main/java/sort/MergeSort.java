package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * todo 描述作用
 *
 * @author 逼哥
 * @date 2019/10/5
 */
public class MergeSort {

    /**
     * 将arr[left,middle]和arr[meddle+1,right]两坨进行归并
     *
     * @param arr    待排序数组
     * @param left   左侧索引
     * @param middle 中间索引
     * @param right  右侧索引
     */
    private static void merge(int[] arr, int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int k = 0;
        //开辟一个临时空间来存储arr[left,right]这段数据
        int[] temp = new int[right - left + 1];
        while (i <= middle && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        //看一哈哪个还有剩的
        while (i <= middle) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        //把临时数组赋值给原数组
        System.arraycopy(temp, 0, arr, left, temp.length);
    }

    private void merge2(int[] arr, int left, int middle, int right) {
        //先建立一个临时空间,将arr[left,right]这段数组copy进去
        int[] tempArr = new int[right - left + 1];
        System.arraycopy(arr, left, tempArr, 0, tempArr.length);
        int i = left;
        //j的定义是第二段数组的第一个元素
        int j = middle + 1;
        //遍历这个临时数组,将里面的值放进arr中
        for (int k = left; k <= right; k++) {
            //若i超出了middle范围,说明右边还有没放完的,此时直接将右边所有放入
            if (i > middle) {
                arr[k] = tempArr[j++ - left];
                //若j超出了right范围,说明左边还有没放完的,此时直接将左边所有放入
            } else if (j > right) {
                arr[k] = tempArr[i++ - left];
                //若左边比较小,则将左边放入对应位置,同时索引++
            } else if (tempArr[i - left] < tempArr[j - left]) {
                arr[k] = tempArr[i++ - left];
            } else {
                arr[k] = tempArr[j++ - left];
            }
        }
    }

    public int[] mergeSort(int[] arr, int length) {
        mergeSort0(arr, 0, length - 1);
        return arr;
    }

    private void mergeSort0(int[] arr, int left, int right) {
        //                if (left >= right) {
        //                    return;
        //                }
        //当区间比较小的时候,可以转为使用插入排序,性能会有些提高
        if (right - left <= 15) {
            insertSort(arr, left, right);
            return;
        }
        //对arr的前半部分进行排序
        int middle = (left + right) / 2;

        mergeSort0(arr, left, middle);
        mergeSort0(arr, middle + 1, right);
        //在近乎有序的情况下可以减少归并次数
        if (arr[middle] > arr[middle + 1]) {
            merge(arr, left, middle, right);
        }
    }

    @Test public void mergeSortTest() {
        int[] arr = { 10, 8, 4, 5, 6, 9, 1 };
        System.out.println(Arrays.toString(mergeSort(arr, arr.length)));
    }

    /**
     * 特殊的插入排序,对[left,right]区间进行排序
     */
    private void insertSort(int[] arr, int left, int right) {
        for (int i = left + 1; i < right + 1; i++) {
            //value保存的是待插入的元素
            int value = arr[i];
            int j = i - 1;
            //查找插入的位置
            for (; j >= left; j--) {
                if (arr[j] > value) {
                    //如果后面的小了,就不断往前交换,就把a[j]处的元素前移
                    arr[j + 1] = arr[j];
                } else {
                    //说明这个是有序的,前面的也已经有序
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }

    @Test public void bench() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            mergeSort(SortUtil.nearlySortedRandomArr(200, 1), 200);
        }
        System.out.println("归并排序的时间为" + (System.currentTimeMillis() - startTime));
    }
}
