package tree;

import org.junit.Before;

import java.util.Arrays;

/**
 * java的堆(数组实现的二叉查找树)
 *
 * @author 逼哥
 * @date 2019/10/10
 */
public class Heap {
    private int capacity;
    //已存储的个数
    private int count;
    private int[] data;

    public Heap() {
        this(100);
    }

    public Heap(int capacity) {
        this.data = new int[capacity + 1];
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(5);
        heap.insert(10);
        heap.insert(1);
        heap.insert(4);
        heap.insert(8);
        heap.insert(9);
        heap.insert(15);
        heap.insert(11);
        heap.removeMax();
        System.out.println(Arrays.toString(heap.getData()));


////       buildHeap(nums,nums.length-1);
//        sort(nums);
//        System.out.println(Arrays.toString(nums));

    }

    @Before
    public void before() {

    }

    private void buildHeap() {
        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }

    /**
     * 下方堆化
     *
     * @param i 当前需要堆化的下标
     */
    private void shiftDown(int i) {
        while (2 * i <= count) {
            //表示此轮循环 j和i交换 j是左子节点
            int j = 2 * i;
            if (j + 1 <= count && data[j + 1] > data[j]) {
                j++;
            }
            if (data[i] > data[j]) {
                break;
            }
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
            // 记录上次的shiftDown后的下标
            i = j;
        }
    }

    public int[] getData() {
        return data;
    }

    public void insert(int data) {
        if (isFull()) {
            return;
        }
        this.data[++count] = data;
        int i = count;
        shiftUp(i);
    }

    /**
     * 从下往上堆化
     *
     * @param i
     */
    private void shiftUp(int i) {
        while (i / 2 > 0 && data[i] > data[i / 2]) {
            int temp = data[i];
            data[i] = data[i / 2];
            data[i / 2] = temp;
            i = i / 2;
        }
    }

    public void removeMax() {
        remove(1);
    }

    public void remove(int index) {
        if (count == 0) {
            return;
        }
        //将堆中最后一个元素挪到堆顶
        data[index] = data[count];
        data[count--] = 0;
        //重新堆化
        shiftDown(index);
    }

}
