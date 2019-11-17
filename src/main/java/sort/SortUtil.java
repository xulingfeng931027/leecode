package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author 逼哥
 * @date 2019/10/4
 */

public class SortUtil {
    /**
     * 随机生成n个元素的数组
     *
     * @param length
     * @return
     */
    public static int[] randomArr(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new Random().nextInt(1000);
        }
        return arr;
    }
    /**
     * 随机生成n个元素的数组
     *
     * @return
     */
    public static int[] standardArr() {
        int[] arr = new int[]{2,1,4,10,6,8,3,12,5,13,20,7,9};
//        for (int i = 0; i < length; i++) {
//            arr[i] = new Random().nextInt(1000);
//        }
        return arr;
    }

    /**
     * 随机交换一个数组n次,生成一个近乎有序的数组
     */
    public static int[] nearlySortedRandomArr(int length, int change) {
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(1000);
        }
        Arrays.sort(arr);
        for (int j = 0; j < change; j++) {
            int left = random.nextInt(length - 1);
            int right = left+1;
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        return arr;
    }

}
