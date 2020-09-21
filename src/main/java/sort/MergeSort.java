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

    //实现较复杂
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


    private void mergeSort0(Comparable[] a, int left, int right) {
        //                if (left >= right) {
        //                    return;
        //                }
        //当区间比较小的时候,可以转为使用插入排序,性能会有些提高
        if (right - left <= 15) {
            insertSort(a, left, right);
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
     * 特殊的插入排序,对[left,right]区间进行排序
     */
    private void insertSort(Comparable[] a, int left, int right) {
        for (int i = left + 1; i < right + 1; i++) {
            //value保存的是待插入的元素
            Comparable value = a[i];
            int j = i - 1;
            //查找插入的位置
            for (; j >= left; j--) {
                if (less(value, a[j])) {
                    //如果后面的小了,就不断往前交换,就把a[j]处的元素前移
                    a[j + 1] = a[j];
                } else {
                    //说明这个是有序的,前面的也已经有序
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        MergeSort merge = new MergeSort(new Integer[]{11, 7, 5, 3, 4, 32, 1});
        merge.sort();
        merge.show();
    }

    /**
     * 排序操作
     */
    @Override
    public void sort() {
        mergeSort0(a, 0, a.length - 1);
    }
}
