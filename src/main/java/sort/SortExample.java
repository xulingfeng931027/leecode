package sort;

/**
 * @author Xulingfeng
 * @description 排序算法模板
 * @date 2020/9/12
 */
@SuppressWarnings("unchecked")
public abstract class SortExample {
    Comparable[] a;

    public SortExample(Comparable[] a) {
        this.a = a;
    }

    /**
     * 排序操作
     *
     */
    public abstract void sort();

    protected boolean less(Comparable first, Comparable second) {
        return first.compareTo(second) < 0;
    }

    protected void exchange( int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public void show() {
        for (Comparable comparable : a) {
            System.out.print(comparable + " ");
        }
        System.out.println();
    }

    public boolean isSorted() {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

}
