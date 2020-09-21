package sort;

/**
 * 选择排序法
 * @author Xulingfeng
 * @description
 * @date 2020/9/13
 */
public class ChooseSort extends SortExample {


    public ChooseSort(Comparable[] a) {super(a);}

    @Override
    public void sort() {
        for (int i = 0; i < a.length; i++) {
            //从前n个元素中选出最小的 放在合适的索引上
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exchange(i, min);
            show();
        }
    }

    public static void main(String[] args) {
        SortExample sortExample = new ChooseSort(new Integer[]{9,3, 4, 5, 1,6, 2});
        sortExample.sort();
        System.out.println(sortExample.isSorted());
    }
}
