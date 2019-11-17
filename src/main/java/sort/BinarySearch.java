package sort;

import org.junit.Test;

/**
 * 二分查找法
 *
 * @author 逼哥
 * @date 2019/10/7
 */
public class BinarySearch {

    /**
     * 假设数组已经按升序排列了,找key值所在的索引
     *
     * @param arr
     * @param key
     * @return 找不到返回-1
     */
    public static int binarySearch1(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int middle = (start + end) >> 1;
            if (arr[middle] == key) {
                return middle;
            } else if (arr[middle] < key) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return -1;
    }

    /**
     * 假设数组已经按升序排列了,且有重复值.找key值所在的第一个索引
     *
     * @param arr
     * @param key
     * @return 找不到返回-1
     */
    public static int binarySearch2(int[] arr, int key) {
        int index = binarySearch1(arr, key);
        if (index == -1) {
            return -1;
        } else {
            for (int i = index; i >= 0; i--) {
                if (arr[i] != arr[index]) {
                    //找到第一个不同的元素
                    return ++i;
                }
            }
            return 0;
        }
    }

    /**
     * 递归实现
     *
     * @param arr
     * @param key
     * @return
     */
    public static int binarySearch11(int[] arr, int key) {
        return binarySearchInternal(arr, key, 0, arr.length - 1);
    }

    private static int binarySearchInternal(int[] arr, int key, int start, int end) {
        int middle = (start + end) >> 1;
        //递归退出条件为start>end,即一直没有找到这个key
        if (start > end) {
            return -1;
        }
        //或者找到了符合条件的key
        if (arr[middle] == key) {
            return middle;
        } else if (arr[middle] < key) {
            return binarySearchInternal(arr, key, middle + 1, end);
        } else {
            return binarySearchInternal(arr, key, start, middle - 1);
        }
    }

    @Test public void test() {
        int[] arr = { 1, 2, 4, 6, 7, 7, 9, 10 };
        System.out.println(binarySearch2(arr, 7));
    }

}
