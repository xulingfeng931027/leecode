package sort;

/**
 * 归并排序
 *
 * @author 逼哥
 * @date 2019/10/5
 */
public class MergeSort extends SortExample {

    public MergeSort(Comparable[] a) {
        super(a);
    }

    /**
     * 将arr[left,middle]和arr[meddle+1,right]两坨进行归并
     *
     * @param a      待排序数组
     * @param left   左侧索引
     * @param middle 中间索引
     * @param right  右侧索引
     */
    private void merge(Comparable[] a, int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int k = 0;
        //开辟一个临时空间来存储arr[left,right]这段数据
        Comparable[] temp = new Comparable[right - left + 1];
        while (i <= middle && j <= right) {
            if (less(a[i], a[j])) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        //看一哈哪个还有剩的
        while (i <= middle) {
            temp[k++] = a[i++];
        }
        while (j <= right) {
            temp[k++] = a[j++];
        }
        //把临时数组赋值给原数组
        System.arraycopy(temp, 0, a, left, temp.length);
    }

    public static void main(String[] args) {
        MergeSort merge = new MergeSort(new Integer[]{1, 3, 5, 7, 2, 4, 6, 8});
        merge.sort();
    }

    private void mergeSort0(Comparable[] a, int left, int right) {

        if (left >= right) {
            return;
        }
        //对arr的前半部分进行排序
        int middle = (left + right) / 2;

        mergeSort0(a, left, middle);
        mergeSort0(a, middle + 1, right);
        //在近乎有序的情况下可以减少归并次数
        if (less(a[middle + 1], a[middle])) {
            merge(a, left, middle, right);
        }
    }

    /**
     * 排序操作
     */
    @Override
    public void sort() {
        mergeSort0(a, 0, a.length - 1);
    }
}
