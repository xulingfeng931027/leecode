package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * todo 描述作用
 *
 * @author 逼哥
 * @date 2019/10/5
 */
public class SimpleSort {
    @Test public void benchMarkSortTest() {

        int[] arr = SortUtil.randomArr(100000);
        int[] arrCopy = Arrays.copyOf(arr, 100000);
        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            bubbleSort(arr,100000);
        }
        System.out.println("冒泡排序的时间为" + (System.currentTimeMillis() - startTime2));
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            insertSort(arrCopy);
        }
        System.out.println("插入排序的时间为" + (System.currentTimeMillis() - startTime));

    }

    /**
     * 冒泡排序是原地排序算法,只需要常量级别的额外空间,
     * 此外如果两个元素相等我们也不改变其顺序,因此他是稳定的排序算法
     *
     * @param arr
     * @return
     */
    public int[] maopaoSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            boolean flag = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    //说明有数据交换
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return arr;
    }

    @Test public void maopaoSortTest() {
        int[] arr = { 3, 5, 4, 1, 2, 6 };
        System.out.println(Arrays.toString(maopaoSort(arr)));
    }

    public int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //value保存的是待插入的元素
            int value = arr[i];
            int j = i - 1;
            //查找插入的位置
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    //如果前面的比较大,就不断往前交换,就把a[j]处的元素前移
                                        arr[j + 1] = arr[j];
                    //如果后面的小了,就不断往前交换,就把a[j]处的元素前移,这里也做了三次赋值
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                } else {
                    //说明这个是有序的,前面的也已经有序
                    break;
                }
            }
                        arr[j + 1] = value;
        }
        return arr;
    }

    @Test public void insertSortTest() {
        int[] arr = { 8, 5, 4, 1, 2, 6 };
        System.out.println(Arrays.toString(insertSort(arr)));

    }
    // 冒泡排序，a 表示数组，n 表示数组大小
    public void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;  // 表示有数据交换
                }
            }
            if (!flag) {
                break;  // 没有数据交换，提前退出
            }
        }
    }

}
