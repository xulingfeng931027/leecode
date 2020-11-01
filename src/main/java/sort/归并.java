package sort;

import java.util.Arrays;

/**
 * @author xulingfeng
 * @description
 * @date 2020/10/17
 */
public class 归并 {

    public static void main(String[] args) {
        归并 solution = new 归并();
        int[] a = {3, 1, 4, 5, 2, 0};
        solution.mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    public void mergeSort(int[] a) {
        mergeSort0(a, 0, a.length - 1);
    }

    public void mergeSort0(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        mergeSort0(a, left, middle);
        mergeSort0(a, middle + 1, right);
        merge(a, left, middle, right);
    }

    private void merge(int[] a, int left, int middle, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= right) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= middle) {
            temp[k++] = a[i++];
        }
        while (j <= right) {
            temp[k++] = a[j++];
        }
        System.arraycopy(temp, 0, a, left, temp.length);
    }

}
